package cn.rongcapital.sisyphus.demo.bangbang.steps.login;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.stereotype.Component;

import cn.rongcapital.sisyphus.base.BaseStep;
import cn.rongcapital.sisyphus.demo.bangbang.pages.base.PageFactory;
import cn.rongcapital.sisyphus.demo.bangbang.pages.choosepro.ChooseProPage;
import cn.rongcapital.sisyphus.demo.bangbang.pages.login.LoginPage;
import junit.framework.Assert;

/**
 * @author nianjun
 * 
 */

@Component
public class LoginStep extends BaseStep {
    private LoginPage loginPage;

    private ChooseProPage chooseProPage;

    @When("我访问了融数金服的首页")
    public void iAccessTheMainPageofRongcapital() {
        loginPage = PageFactory.newLoginPage();
        loginPage.accessMainPage();
    }

    @When("我使用用户<$userName>密码<$password>登录融数金服")
    public void iLoginBySpecificUserNameandPassword(String userName, String password) {
        loginPage.login(userName, password);
    }

    @Then("我应该看到登录后的选择项目的页面")
    public void iShouldSeeTheChooseProPage() {
        chooseProPage = PageFactory.newChooseProPage();
        Assert.assertTrue(chooseProPage.isInCurrentPage());
    }
}
