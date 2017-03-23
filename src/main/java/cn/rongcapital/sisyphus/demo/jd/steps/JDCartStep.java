package cn.rongcapital.sisyphus.demo.jd.steps;

import static org.junit.Assert.assertTrue;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.stereotype.Component;

import cn.rongcapital.sisyphus.base.BaseStep;
import cn.rongcapital.sisyphus.demo.jd.pages.PageFactory;
import cn.rongcapital.sisyphus.demo.jd.pages.cartpage.AddtoCartPage;

/**
 * @author nianjun
 * 
 */

@Component
public class JDCartStep extends BaseStep {

    private AddtoCartPage addtoCarPage;

    @Then("我应该看到商品已经放入购入车")
    public void iShouldSeeSkuAlreadyAddedInCar() {
        addtoCarPage = PageFactory.newAddtoCarPage();
        boolean result = addtoCarPage.isSkuAddedInCart();
        assertTrue("商品没有放入购物车", result);
    }

    @When("我去购物车进行结算")
    public void iGotoCarttoCheckout() {
        addtoCarPage.addCarttoCheckout();
    }

}
