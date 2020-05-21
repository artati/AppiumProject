package com.AppiumFramework;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.CheckoutPage;
import pageObjects.FormPage;
import pageObjects.ProductsPage;

import java.io.IOException;
import java.net.MalformedURLException;

public class TS01_TotalAmount extends Capabilities {
    @Test(dataProvider="InputData",dataProviderClass=TestData.class)
    public void totalSum(String input) throws MalformedURLException, InterruptedException {
        service = startServer();
        AndroidDriver driver = capabilities();

        FormPage homepage = new FormPage(driver);
        homepage.countryList.click();
        Utilities u = new Utilities(driver);
        u.scrollToText("Argentina");
        homepage.selectCountry.click();
        homepage.nameField.sendKeys(input);
        driver.hideKeyboard();
        homepage.gender.click();
        homepage.btnShop.click();

        ProductsPage prodPage = new ProductsPage(driver);
        int size = prodPage.productNameList.size();
        for (int i = 0; i < size; i++) {
            WebElement productToAdd = u.scrollToTextAddToCard("ADD TO CART");
            productToAdd.click();
        }
        prodPage.btnAddToCard.click();
        Thread.sleep(4000);

        CheckoutPage checkOut = new CheckoutPage(driver);
        int count = checkOut.productPriceList.size();
        double sum = 0;
        for (int i = 0; i < count; i++) {
            String amount1 = checkOut.productPriceList.get(i).getText();
            double amount = getAmount(amount1);
            sum = sum + amount;
        }

        System.out.println(sum + " sum of products");
        String total = checkOut.totalAmount.getText();
        total = total.substring(1);
        double totalValue = Double.parseDouble(total);
        System.out.println(totalValue + " Total value of products");
        Assert.assertEquals(sum, totalValue);
        service.stop();
    }

    public static double getAmount(String value) {
        value = value.substring(1);
        double amount2value = Double.parseDouble(value);
        return amount2value;
    }

    @BeforeTest
    public void killAllNodes() throws InterruptedException, IOException {
        Runtime.getRuntime().exec("taskkill /F /IM node.exe");
        Thread.sleep(6000);
    }
}
