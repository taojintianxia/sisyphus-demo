package cn.rongcapital.sisyphus.demo.jd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cn.rongcapital.sisyphus.base.BasePage;

public class LoginPage extends BasePage {

    private static LoginPage instance = new LoginPage();

    private LoginPage() {}

    public static LoginPage getInstance() {
        return instance;
    }

    public void openWebSite(String url) {
        openUrl(url);
    }

    public void login(String userName, String passwd) {
        WebElement userNameInputBox = $(By.id("userName"));
        WebElement passWordInputBox = $(By.id("passWord"));
        WebElement loginButtion = $(By.id("submit"));

        typeTextBox(userNameInputBox, userName);
        typeTextBox(passWordInputBox, passwd);
        clickOn(loginButtion);
    }


}
