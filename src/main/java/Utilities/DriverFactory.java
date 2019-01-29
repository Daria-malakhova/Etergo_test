package Utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {


    public WebDriver driver;

    public WebDriver launchDriver(String platformName, String platformVersion, String deviceName, String UDID,String app, String appActivity, String packageName,String orientation, String fullReset) throws MalformedURLException {


        DesiredCapabilities capabilities = new DesiredCapabilities();

        switch (platformName) {

            case "Android":

                capabilities.setCapability("platformName", platformName);
                capabilities.setCapability("platformVersion", platformVersion);
                capabilities.setCapability("udid", UDID);
                capabilities.setCapability("app", app);
                capabilities.setCapability("deviceName", deviceName);
                capabilities.setCapability("appActivity", appActivity);
                capabilities.setCapability("packageName", packageName);
                capabilities.setCapability("fullReset", fullReset);
                capabilities.setCapability("newCommandTimeout","60");
                capabilities.setCapability("deviceReadyTimeout","60");
                capabilities.setCapability("orientation",orientation);
                driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

                break;

            case "iOS":

                capabilities.setCapability("platformName", platformName);
                capabilities.setCapability("platformVersion", platformName);
                capabilities.setCapability("udid", UDID);
                capabilities.setCapability("app", app);
                capabilities.setCapability("deviceName", deviceName);
                capabilities.setCapability("appActivity", appActivity);
                capabilities.setCapability("packageName", packageName);
                capabilities.setCapability("fullReset", fullReset);
                capabilities.setCapability("newCommandTimeout","60");
                capabilities.setCapability("deviceReadyTimeout","60");
                capabilities.setCapability("orientation",orientation);
                driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                break;
        }
        return driver;
    }


}
