package cn.rongcapital.sisyphus.demo.jd.pages;

import cn.rongcapital.sisyphus.demo.jd.pages.cartpage.AddtoCartPage;
import cn.rongcapital.sisyphus.demo.jd.pages.checkout.JDCheckoutPage;
import cn.rongcapital.sisyphus.demo.jd.pages.mainpage.JDHomePage;
import cn.rongcapital.sisyphus.demo.jd.pages.skupage.JDSkuPage;

/**
 * @author nianjun
 * 
 */

public class PageFactory {

    public static JDHomePage newJdHomePage() {
        return new JDHomePage();
    }

    public static JDSkuPage newJdSkuPage() {
        return new JDSkuPage();
    }
    
    public static AddtoCartPage newAddtoCarPage(){
        return new AddtoCartPage();
    }
    
    public static JDCheckoutPage newJDCheckoutPage(){
        return new JDCheckoutPage();
    }

}
