package cn.rongcapital.sisyphus.demo.jd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cn.rongcapital.sisyphus.base.BrowserDriver;

public class LoginPage{

    private static LoginPage instance = new LoginPage();
    
    private LoginPage() {}    

	public static LoginPage getInstance() {
		return instance;
	}
	
    public void openWebSite(String url) {		
		BrowserDriver.openUrl(url);
    }
	
    public void login(String userName, String passwd) {
        WebElement userNameInputBox = BrowserDriver.findElementBy(By.id("userName"));
        WebElement passWordInputBox = BrowserDriver.findElementBy(By.id("passWord"));
        WebElement loginButtion = BrowserDriver.findElementBy(By.id("submit"));

        BrowserDriver.typeTextBox(userNameInputBox, userName);
        BrowserDriver.typeTextBox(passWordInputBox, passwd);
        BrowserDriver.clickOn(loginButtion);
        
    }

	
}
