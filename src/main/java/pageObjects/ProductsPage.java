package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by Tatiana on 5/18/2020.
 */
public class ProductsPage {
    public ProductsPage(AndroidDriver<AndroidElement> driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
    public WebElement btnAddToCard;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productName")
    public List<WebElement> productNameList;
}
