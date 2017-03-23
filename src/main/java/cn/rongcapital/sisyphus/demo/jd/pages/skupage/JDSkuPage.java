package cn.rongcapital.sisyphus.demo.jd.pages.skupage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cn.rongcapital.sisyphus.base.BasePage;
import lombok.extern.slf4j.Slf4j;

/**
 * @author nianjun
 * 
 */

@Slf4j
public class JDSkuPage extends BasePage {

    private static final Map<String, Integer> sortTypesMap = new HashMap<>();

    static {
        sortTypesMap.put("综合", 0);
        sortTypesMap.put("销量", 1);
        sortTypesMap.put("评论数", 2);
        sortTypesMap.put("新品", 3);
        sortTypesMap.put("价格", 4);
    }

    public boolean iShouldSeeSkuSearchResultPage(String name) {
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

    // 按照类型排序
    public void iSortSKUBySortType(String sortType) {
        List<WebElement> sortTypes = findElementsBy(By.cssSelector(".f-sort>a"));
        for (WebElement aElement : sortTypes) {
            if (aElement.findElement(By.cssSelector("span")).getText().equalsIgnoreCase(sortType)) {
                clickOn(aElement);
            }
        }
    }

    // 检验是否按sortType排序
    public boolean iShouldSeeSKUSortedBySortType(String sortType) {
        boolean result = false;
        waitForPageLoad(1);
        List<WebElement> sortTypes = findElementsBy(By.cssSelector(".f-sort a"));
        WebElement currentType = sortTypes.get(sortTypesMap.get(sortType));
        if ("curr".equalsIgnoreCase(currentType.getAttribute("class"))) {
            result = true;
        }

        return result;
    }

    // 将<$sortType>最靠前的商品放入购入车
    public void iPutSkuByMostSortType() {
        List<WebElement> addtoCarButtons = findElementsBy(By.cssSelector(".p-o-btn.addcart"));
        WebElement firstAddToCarButton = addtoCarButtons.get(0);
        clickOn(firstAddToCarButton);
    }

}
