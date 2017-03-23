package cn.rongcapital.sisyphus.demo.bangbang.pages.choosepro;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.google.common.base.Strings;

import cn.rongcapital.sisyphus.base.BasePage;
import lombok.extern.slf4j.Slf4j;

/**
 * @author nianjun
 * 
 */

@Slf4j
public class ChooseProPage extends BasePage {

    // 是否在选择项目页面
    public boolean isInCurrentPage() {
        waitForPageLoad(2);
        WebElement title = $(By.cssSelector(".title"));
        String titleStr = title.getText();
        if (Strings.isNullOrEmpty(titleStr)) {
            return false;
        }

        return titleStr.contains("请选择项目:");
    }

    // 选取帮帮助学并提交
    public void chooseBangbangProandSubmit() {
        List<WebElement> projects = findElementsBy(By.cssSelector(".item.ng-binding"));
        if (projects.isEmpty()) {
            log.error("无法定位任何项目");
        }

        WebElement bangbangPro = projects.get(1);
        WebElement submitButton = $(By.cssSelector(".btn.btn-confirm"));

        clickOn(bangbangPro);
        clickOn(submitButton);
    }
}
