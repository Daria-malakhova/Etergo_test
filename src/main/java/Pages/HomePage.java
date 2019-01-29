package Pages;

import org.openqa.selenium.By;
import org.testng.Assert;

public class HomePage extends BasePage{


    public static By btnZoomIn = By.id("com.etergo.techassessment:id/btnZoomIn");
    public static By btnZoomOut = By.id("com.etergo.techassessment:id/btnZoomOut");
    public static By txtViewZoomValue = By.id("com.etergo.techassessment:id/textViewZoomValue");
    public static By txtViewHeader = By.id("com.etergo.techassessment:id/textViewHeader");



    public static String zoom() {
        String zoomValue = driver.findElement(HomePage.txtViewZoomValue).getText();
        String[] zoom1 = zoomValue.split("%");
        return zoom1[0];
    }

    public static void verifyElemHomepage() {

        try {
            if (driver.findElement(HomePage.txtViewHeader).isDisplayed()) {
                System.out.println("Homepage header displayed successfully");
                Assert.assertTrue(driver.findElement(HomePage.btnZoomIn).isEnabled());
                Assert.assertTrue(driver.findElement(HomePage.btnZoomOut).isEnabled());
                String zoomValue = driver.findElement(HomePage.txtViewZoomValue).getText();
                Assert.assertEquals(zoomValue, "100%");
                System.out.println("Homepage validation successfully completed");

            } else {
                System.out.println("Homepage validation failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void clickZoomInButton() {

        try {
            if (driver.findElement(HomePage.btnZoomIn).isDisplayed()) {

                BasePage.temp.setZoomPercentage(zoom());
                driver.findElement(HomePage.btnZoomIn).click();
                System.out.println("ZoomIn Button clicked successfully");
            } else {
                System.out.println("Not able to click ZoomIn button");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void validateZoomValueforZoomIn() {

        try {
            if (driver.findElement(HomePage.txtViewZoomValue).isDisplayed()) {

                int result = Integer.parseInt((zoom()));
                if (result > Integer.parseInt(BasePage.temp.zoomPercentage)) {
                    System.out.println("Zoom value before ZoomIn : " + BasePage.temp.zoomPercentage + "%");
                    System.out.println("Zoom value increased  by" + "25%");
                    System.out.println("Zoom value after ZoomIN :" + zoom() + "%");
                }
            } else {
                System.out.println("ZoomIN button validation failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void clickZoomOutButton() {

        try {
            if (driver.findElement(HomePage.btnZoomOut).isDisplayed()) {

                BasePage.temp.setZoomPercentage(zoom());
                driver.findElement(HomePage.btnZoomOut).click();
                System.out.println("ZoomOut Button clicked successfully");
            } else {
                System.out.println("Not able to click ZoomOut button");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void validateZoomValueforZoomOut() {

        try {
            if (driver.findElement(HomePage.txtViewZoomValue).isDisplayed()) {

                int result = Integer.parseInt((zoom()));
                if (result < Integer.parseInt(BasePage.temp.zoomPercentage)) {

                    System.out.println("Zoom value before ZoomOut : " + BasePage.temp.zoomPercentage + "%");
                    System.out.println("Zoom value decreased by" + " 25%");
                    System.out.println("Zoom value after ZoomOut :" + zoom() + "%");
                }
            } else {
                System.out.println("ZoomOut button validation failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void clickZoomINMax() {
        try {
            int currentVal = Integer.parseInt(zoom());
            for (int i = currentVal; i <= 200; i = i + 25) {
                driver.findElement(HomePage.btnZoomIn).click();
                BasePage.temp.setZoomPercentage(zoom());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void clickZoomOutMax() {
        try {
            int currentVal = Integer.parseInt(zoom());
            for (int i = currentVal; i > 25; i = i - 25) {
                driver.findElement(HomePage.btnZoomOut).click();
                BasePage.temp.setZoomPercentage(zoom());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void validateZoomInDisabled() {
        try {

            if (zoom().equals("200")) {
                Assert.assertFalse(driver.findElement(HomePage.btnZoomIn).isEnabled());
                System.out.println("ZoomIn Disabled");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void validateZoomOutDisabled() {
        try {

            if (zoom().equals("25")) {
                Assert.assertFalse(driver.findElement(HomePage.btnZoomOut).isEnabled());
                System.out.println("ZoomIn Disabled");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
