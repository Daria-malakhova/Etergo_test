package com.stepDefinitions;

import Pages.BasePage;
import Pages.HomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageSteps {



    @Given("^Customer is on Etergo HomePage$")
    public static void homePageVerification() {
        BasePage.validateHomePage();
    }

    @Then("^Validate the elements on Etergo HomePage$")
    public static void validateHomePageElements() {
        HomePage.verifyElemHomepage();
    }

    @When("^Customer clicks on ZoomIn button$")
    public static void clickZoomIn() {
        HomePage.clickZoomInButton();
    }

    @Then("^Validate Zoom value is increased by 25%$")
    public static void validateZoomIn() {
        HomePage.validateZoomValueforZoomIn();
    }

    @When("^Customer clicks on ZoomOut button$")
    public static void clickZoomOut() {
        HomePage.clickZoomOutButton();
    }

    @When("^Customer clicks on ZoomIn button for Maximum limit$")
    public static void clickZoomInMaxVal() {
        HomePage.clickZoomINMax();
    }

    @Then("^Validate ZoomIn button is disabled$")
    public static void disableZoomIn() {
        HomePage.validateZoomInDisabled();
    }

    @Then("^Validate Zoom value is decreased by 25%$")
    public static void validateZoomOut() {
        HomePage.validateZoomValueforZoomOut();
    }

    @When("^Customer clicks on ZoomOut button for Maximum limit$")
    public static void clickZoomOutMaxVal() { HomePage.clickZoomOutMax();
    }

    @Then("^Validate ZoomOut button is disabled$")
    public static void disableZoomOut() {
        HomePage.validateZoomOutDisabled();
    }


}
