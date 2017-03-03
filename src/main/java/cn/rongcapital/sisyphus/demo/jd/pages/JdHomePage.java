package cn.rongcapital.sisyphus.demo.jd.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import cn.rongcapital.sisyphus.base.BasePage;
import lombok.extern.slf4j.Slf4j;

/**
 * @author nianjun
 * 
 */

@Component
@Slf4j
public class JdHomePage extends BasePage {

    private static final String HOME_PAGE = "https://www.jd.com";

    public void accessHomePage() {
        openUrl(HOME_PAGE);
    }

    public void searchSku(String skuName) {
        WebElement searchField = $(By.id("key"));
        WebElement searchButton = $(By.cssSelector(".search-m .button"));
        typeTextBox(searchField, skuName);
        clickOn(searchButton);
    }

    public boolean iShouldSeeSkuSearchResultPage() {
        return isElementPresent(By.cssSelector(".sl-v-logos"));
    }

    // 选取相关类型的白酒
    public void chooseRelatedType(String type) {
        WebElement typeArea = findElementsBy(By.cssSelector(".J_valueList")).get(1);
        List<WebElement> typeList = typeArea.findElements(By.cssSelector("a"));
        if (typeList.isEmpty()) {
            log.error("无法找到相关类型");
            return;
        }

        for (WebElement typeElement : typeList) {
            if (typeElement.getText().equals(type)) {
                clickOn(typeElement);
            }
        }
    }

    // 检查茅台是否存在(酱香酒)
    public boolean iShouldSeeRelatedType(String type) {
        String maotai = "brand-12310";
        return isElementPresent(By.id(maotai));
    }

}
