package Pages;

import Utilities.*;
import com.cucumber.listener.ExtentProperties;
import org.openqa.selenium.WebDriver;


public class BasePage {

    public static WebDriver driver;
    public static TempVariable temp;

    static {
        try {
            RunConfiguration runConfig = new RunConfiguration();
            DriverFactory driverClass = new DriverFactory();
            temp=new TempVariable();
            driver = driverClass.launchDriver(runConfig.strPlatformName,
                    runConfig.strPlatformVersion, runConfig.strDeviceName, runConfig.strUDID,
                    runConfig.strApp, runConfig.strAppActivity, runConfig.strPackageName,
                    runConfig.strOrientation, runConfig.strFullReset);

            ExtentProperties extentProperties = ExtentProperties.INSTANCE;
            extentProperties.setReportPath("output/myreport.html");



        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void validateHomePage() {

        try {
            if (driver.findElement(HomePage.txtViewHeader).isDisplayed()) {
                System.out.println(("Customer in App Homepage"));
            } else {
                System.out.println(("Homepage not displayed"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }






}
