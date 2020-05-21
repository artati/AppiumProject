package pageObjects;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FormPage {
    public FormPage(AndroidDriver<AndroidElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "android:id/text1")
    public WebElement countryList;

    @AndroidFindBy(xpath = "//*[@text='Argentina']")
    public WebElement selectCountry;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    public WebElement nameField;

    @AndroidFindBy(xpath = "//*[@text='Female']")
    public WebElement gender;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    public WebElement btnShop;
}
