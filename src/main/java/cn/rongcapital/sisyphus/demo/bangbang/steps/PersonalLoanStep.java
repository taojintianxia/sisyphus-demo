package cn.rongcapital.sisyphus.demo.bangbang.steps;

import static junit.framework.Assert.assertTrue;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.stereotype.Component;

import cn.rongcapital.sisyphus.base.BaseStep;
import cn.rongcapital.sisyphus.demo.bangbang.pages.HomePage;
import cn.rongcapital.sisyphus.demo.bangbang.pages.base.PageFactory;
import cn.rongcapital.sisyphus.demo.bangbang.pages.choosepro.ChooseProPage;

/**
 * @author nianjun
 * 
 */

@Component
public class PersonalLoanStep extends BaseStep {

    private ChooseProPage chooseProPage;

    private HomePage homePage;

    @When("我在选择项目页面选择了帮帮助学并提交")
    public void iChooseBangbangandSubmit() {
        chooseProPage = PageFactory.newChooseProPage();
        chooseProPage.chooseBangbangProandSubmit();
    }

    @Then("我应该看到帮帮助学的首页")
    public void iShouldInBangbangMainPage() {
        homePage = PageFactory.newHomePage();
        assertTrue(homePage.isInCurrentPage());
    }

}
