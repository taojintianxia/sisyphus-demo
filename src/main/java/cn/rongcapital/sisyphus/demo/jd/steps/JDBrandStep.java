package cn.rongcapital.sisyphus.demo.jd.steps;

import static org.junit.Assert.assertTrue;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.stereotype.Component;

import cn.rongcapital.sisyphus.base.BaseStep;
import cn.rongcapital.sisyphus.demo.jd.pages.PageFactory;
import cn.rongcapital.sisyphus.demo.jd.pages.skupage.JDSkuPage;

/**
 * @author nianjun
 * 
 */

@Component
public class JDBrandStep extends BaseStep {

    private JDSkuPage jdSkuPage;

    @Then("我应该看到各种品牌的<$name>")
    public void iShouldSeeSkuSearchResult(String name) {
        jdSkuPage = PageFactory.newJdSkuPage();
        boolean result = jdSkuPage.iShouldSeeSkuSearchResultPage(name);
        assertTrue("未看到各种品牌的" + name, result);
    }

    @When("我选取了<$type>型的相关产品")
    public void iChooseRelatedTypeProduct(String type) {
        jdSkuPage.chooseRelatedType(type);
    }

    @Then("我应该看到<$type>型相关产品的品牌")
    public void iShouldSeeRelatedProductBrand(String type) {
        boolean result = jdSkuPage.iShouldSeeRelatedType(type);
        assertTrue("无法看到" + type + "类型相关产品的品牌", result);
    }

    @When("我按<$sortType>对商品进行了排序")
    public void iSortSKUBySortType(String sortType) {
        jdSkuPage.iSortSKUBySortType(sortType);
    }

    @Then("我应该看到商品已经按照<$sortType>进行了排序")
    public void iShouldSeeSKUSortedBySortType(String sortType) throws Exception {
        assertTrue("商品没有按照" + sortType + "排序", jdSkuPage.iShouldSeeSKUSortedBySortType(sortType));
    }

    @When("我将<$sortType>最多的商品放入购入车")
    public void iPutSkuByMostSortType(String sortType) {
        jdSkuPage.iPutSkuByMostSortType();
    }

}
