package cn.rongcapital.sisyphus.demo.bangbang.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cn.rongcapital.sisyphus.base.BasePage;

/**
 * @author nianjun
 * 
 */

public class HomePage extends BasePage {

    public boolean isInCurrentPage() {
        boolean result = false;
        waitForPageLoad(2);
        WebElement homePageOption = $(
                By.cssSelector(".form-control.pull-right.head-select.ng-pristine.ng-untouched.ng-valid.ng-not-empty"));
        List<WebElement> options = homePageOption.findElements(By.cssSelector("option"));

        for (WebElement option : options) {
            if (option.getText().equals("帮帮助学")) {
                if (option.isSelected()) {
                    result = true;
                }
            }
        }

        return result;
    }

}
