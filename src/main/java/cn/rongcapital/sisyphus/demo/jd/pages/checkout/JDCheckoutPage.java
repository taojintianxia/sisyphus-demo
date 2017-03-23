package cn.rongcapital.sisyphus.demo.jd.pages.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.google.common.base.Strings;

import cn.rongcapital.sisyphus.base.BasePage;
import cn.rongcapital.sisyphus.demo.jd.utils.Constants;

/**
 * @author nianjun
 * 
 */

public class JDCheckoutPage extends BasePage {

    // 验证是否进入了CheckoutPage
    public boolean isInCheckoutPage() {
        WebElement pageLogo = $(By.cssSelector(".link2>b"));
        return !Strings.isNullOrEmpty(pageLogo.getText())
                && Constants.CHECKOUT_PAGE_TITLE.equalsIgnoreCase(pageLogo.getText().trim());
    }

}
