package cn.rongcapital.sisyphus.demo.jd.steps;

import static org.junit.Assert.assertTrue;

import org.jbehave.core.annotations.Then;
import org.springframework.stereotype.Component;

import cn.rongcapital.sisyphus.base.BaseStep;
import cn.rongcapital.sisyphus.demo.jd.pages.PageFactory;
import cn.rongcapital.sisyphus.demo.jd.pages.checkout.JDCheckoutPage;

/**
 * @author nianjun
 * 
 */

@Component
public class JDCheckoutStep extends BaseStep {

    private JDCheckoutPage jDCheckoutPage;

    @Then("我应该看到商品等待被结算")
    public void iShouldSeeSKUIsPendingCheckout() {
        jDCheckoutPage = PageFactory.newJDCheckoutPage();
        assertTrue("没有看到商品等待被结算", jDCheckoutPage.isInCheckoutPage());
    }

}
