package cn.rongcapital.sisyphus.demo.jd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import cn.rongcapital.sisyphus.base.BrowserDriver;

/**
 * @author nianjun
 * 
 */

@Component
public class JdHomePage {

    private static final String HOME_PAGE = "https://www.jd.com";

    public void accessHomePage() {
        BrowserDriver.openUrl(HOME_PAGE);
    }

    public void searchSku(String skuName) {
        WebElement searchField = BrowserDriver.findElementBy(By.id("key"));
        WebElement searchButton = BrowserDriver.findElementBy(By.cssSelector(".search-m .button"));
        BrowserDriver.typeTextBox(searchField, skuName);
        BrowserDriver.clickOn(searchButton);
    }

    public boolean iShouldSeeSkuSearchResultPage() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

}
