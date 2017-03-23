package cn.rongcapital.sisyphus.demo.bangbang.pages.base;

import cn.rongcapital.sisyphus.demo.bangbang.pages.HomePage;
import cn.rongcapital.sisyphus.demo.bangbang.pages.choosepro.ChooseProPage;
import cn.rongcapital.sisyphus.demo.bangbang.pages.login.LoginPage;

/**
 * @author nianjun
 * 
 */

public class PageFactory {

    public static ChooseProPage newChooseProPage() {
        return new ChooseProPage();
    }

    public static LoginPage newLoginPage() {
        return new LoginPage();
    }

    public static HomePage newHomePage() {
        return new HomePage();
    }

}
