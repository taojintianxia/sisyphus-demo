package cn.rongcapital.sisyphus.demo.jd.steps;

import org.jbehave.core.annotations.When;
import org.springframework.stereotype.Component;

import cn.rongcapital.sisyphus.base.BaseStep;
import cn.rongcapital.sisyphus.demo.jd.pages.PageFactory;
import cn.rongcapital.sisyphus.demo.jd.pages.mainpage.JDHomePage;

/**
 * @author nianjun
 * 
 */

@Component
public class JDHomePageStep extends BaseStep {

    private JDHomePage jdHomePage;

    @When("我访问了京东的首页")
    public void iAccessJdHomePage() {
        jdHomePage = PageFactory.newJdHomePage();
        jdHomePage.accessHomePage();
    }

    @When("我在搜索栏中搜索商品<$name>")
    public void iSearchSkuInSkuSearchField(String name) throws Exception {
        jdHomePage.searchSku(name);
    }

}
