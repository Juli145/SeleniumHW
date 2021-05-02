package Steps;

import Core.DriverConfig;
import Interfaces.IMainPage;
import Patterns.PageObject;
import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static Core.Config.SITE_URL;

public class MainPageSteps extends Steps{

    private final Actions action =  new Actions(DriverConfig.getDriver());

    @Given("^I open Main page$")
    public void iOpenMainPage(){
        logger.info("I open Main page");
        DriverConfig.getDriver().get(SITE_URL);
    }

    @And("^I click button RandomName$")
    public void iClickButtonRandomName() {
        logger.info("I click button RandomName");
        iMainPage.getRandomNameButton().click();
    }

    @And("^I click dropdown$")
    public void iClickDropdown() {
        logger.info("I click dropdown");
        iMainPage.getDropdownDomain().click();
    }

    @And("^I click chosen domain$")
    public void iClickChosenDomain() {
        logger.info("I click chosen domain");
        iMainPage.getChooseDomain().click();
    }

    @And("^I remember email$")
    public void iRememberEmail() {
        logger.info("I remember email");
        String nameOfEmail = iMainPage.getGetEmail().getAttribute("value") + "@rover.info";
    }

    @And("^I open settings$")
    public void iOpenSettings() {
        logger.info("I open settings");
        iMainPage.getSettingsButton().click();
    }

    @And("^I wait for settings to be opened$")
    public void iWaitForSettingsToBeOpened() {
        logger.info("I wait for settings to be opened");
        IMainPage.waitForVisibility(iMainPage.getTenMinButton(), 10);
    }

    @And("^I remember secret address$")
    public void iRememberSecretAddress() {
        logger.info("I remember secret address");
        String secretAddress = iMainPage.getSecretAddress().getAttribute("textContent");
    }

    @And("^I close settings$")
    public void iCloseSettings() {
        logger.info("I close settings");
        iMainPage.getCross().click();
        action.moveByOffset(10, 10).click().build().perform();
    }

    @And("^I check that settings are closed$")
    public void iWaitSettingsToBeClosed() {
        logger.warn("I check that settings are closed");
        WebElement element = PageObject.waitForVisibility(iMainPage.getStringWaitingForNewLetters(), 10);
        Assert.assertTrue(
                "Settings are not closed",
                element.isDisplayed()
        );
    }

    @And("I check text {string}  displayed")
    public void iCheckTextDisplayed() {
        logger.info("I check text {string} displayed");
        Assert.assertEquals(
                "Waiting for letters is not visible",
                "В ожидании новых писем...",
                iMainPage.getStringWaitingForNewLetters().getAttribute("textContent")
        );
    }

    @And("^I click write button$")
    public void iClickWriteButton() {
        logger.info("I click write button");
        iMainPage.getWriteButton().click();
    }
}
