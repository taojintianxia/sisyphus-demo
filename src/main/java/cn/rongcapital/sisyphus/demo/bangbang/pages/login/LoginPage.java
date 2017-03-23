package cn.rongcapital.sisyphus.demo.bangbang.pages.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cn.rongcapital.sisyphus.base.BasePage;
import cn.rongcapital.sisyphus.demo.bangbang.util.ShellReader;

/**
 * @author nianjun
 * 
 */

public class LoginPage extends BasePage {

    private static final String MAIN_PAGE = "http://123.56.79.58:8121/";

    public void accessMainPage() {
        openUrl(MAIN_PAGE);
    }

    public void login(String userName, String password) {
        waitForPageLoad(3);
        // 获取用户名的input
        WebElement userNameField = $(By.name("userLoginName"));

        // 获取用户密码的input
        WebElement passwordField = $(By.name("password"));

        // 获取验证码的input
        WebElement imgCodeField = $(By.name("imgcode"));

        // 获取登录按钮
        WebElement loginButton = $(By.cssSelector(".btn.btn-block.btn-confirm.pm10.ng-binding"));

        typeTextBox(userNameField, userName);
        typeTextBox(passwordField, password);

        String capcha = ShellReader.readCapcha();
        typeTextBox(imgCodeField, capcha);

        clickOn(loginButton);
    }

}
