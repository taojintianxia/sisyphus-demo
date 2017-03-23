package cn.rongcapital.sisyphus.demo.jd.pages.mainpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cn.rongcapital.sisyphus.base.BasePage;

/**
 * @author nianjun
 * 
 */

public class JDHomePage extends BasePage {

    public void accessHomePage() {
        openUrl("https://www.jd.com");
    }

    public void searchSku(String skuName) {
        WebElement searchField = findElementBy(By.id("key"));
        WebElement searchButton = findElementBy(By.cssSelector(".search-m .button"));
        typeTextBox(searchField, skuName);
        clickOn(searchButton);
    }
}
