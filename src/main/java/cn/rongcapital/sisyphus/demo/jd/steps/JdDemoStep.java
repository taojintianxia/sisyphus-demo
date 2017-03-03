package cn.rongcapital.sisyphus.demo.jd.steps;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import cn.rongcapital.sisyphus.base.BaseStep;
import cn.rongcapital.sisyphus.demo.jd.pages.JdHomePage;

/**
 * @author nianjun
 * 
 */

@Component
@ComponentScan(basePackages = "cn.rongcapital.sisyphus.demo.jd.pages")
public class JdDemoStep extends BaseStep {

    @Autowired
    private JdHomePage jdHomePage;

    @When("我访问了京东的首页")
    public void iAccessJdHomePage() {
        jdHomePage.accessHomePage();
    }

    @When("我在搜索栏中搜索商品<$name>")
    public void iSearchSkuInSkuSearchField(String name) throws Exception {
        jdHomePage.searchSku(name);
    }

    @Then("我应该看到各种相关商品的品牌")
    public void iShouldSeeSkuSearchResult() {
        Assert.assertTrue(jdHomePage.iShouldSeeSkuSearchResultPage());
    }

    @When("我选取了<$type>型的相关产品")
    public void iChooseRelatedTypeProduct(String type) {
        jdHomePage.chooseRelatedType(type);
    }

    @Then("我应该看到<$type>型相关产品的品牌")
    public void iShouldSeeRelatedProductBrand(String type) {

    }

}
