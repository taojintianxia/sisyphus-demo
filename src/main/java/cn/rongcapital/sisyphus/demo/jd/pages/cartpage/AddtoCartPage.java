package cn.rongcapital.sisyphus.demo.jd.pages.cartpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.google.common.base.Strings;

import cn.rongcapital.sisyphus.base.BasePage;
import cn.rongcapital.sisyphus.demo.jd.utils.Constants;


/**
 * @author nianjun
 * 
 */

public class AddtoCartPage extends BasePage {

    // 校验商品是否已经放入购入车
    public boolean isSkuAddedInCart() {
        // 因为打开了新的tab
        focusOnNewWindow();
        WebElement successEcho = $(By.cssSelector(".ftx-02"));
        return !Strings.isNullOrEmpty(successEcho.getText())
                && Constants.ADD_TO_CART_SUCCESSFULLY_PROMOT.equalsIgnoreCase(successEcho.getText().trim());
    }

    // 去购物车进行结算
    public void addCarttoCheckout() {
        WebElement addToCartButton = $(By.id("GotoShoppingCart"));
        clickOn(addToCartButton);
    }

}
