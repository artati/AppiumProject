package com.AppiumFramework;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Tatiana on 5/12/2020.
 */
public class Capabilities {
    public static AppiumDriverLocalService service;
    public static AndroidDriver driver;

    public AppiumDriverLocalService startServer() {
        boolean flag = checkIfServerIsRunnning(4723);
        if (!flag) {
            service = AppiumDriverLocalService.buildDefaultService();
            service.start();
        }
        return service;
    }

    public static boolean checkIfServerIsRunnning(int port) {

        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.close();
        } catch (IOException e) {
            //If control comes here, then it means that the port is in use
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }

    public static AndroidDriver capabilities() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();

        //Device Configuration
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "18c2a06b7d14");
        cap.setCapability(MobileCapabilityType.VERSION, "7.1.2");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        cap.setCapability("noReset", "true");
        cap.setCapability("fullReset", "false");

        //App Information
        //cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.appium.android.apis");
        //cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".ApiDemos");
        cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.androidsample.generalstore");
        cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".SplashActivity");

        //Appium Server Details
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        return driver;
    }

    public static void takeScreenshot(String screen) throws IOException {
        File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "\\"+screen+".png"));
    }

}