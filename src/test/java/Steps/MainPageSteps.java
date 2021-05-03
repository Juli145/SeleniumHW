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
    String nameOfEmail;
    String secretAddress;

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
        nameOfEmail = iMainPage.getGetEmail().getAttribute("value") + "@rover.info";
    }

    @And("^I open settings$")
    public void iOpenSettings() {
        logger.info("I open settings");
        iMainPage.getSettingsButton().click();
    }

    @And("^I wait for settings to be opened$")
    public void iWaitForSettingsToBeOpened() {
        logger.info("I wait for settings to be opened");
        PageObject.waitForVisibility(iMainPage.getTenMinButton(), 10);
    }

    @And("^I remember secret address$")
    public void iRememberSecretAddress() {
        logger.info("I remember secret address");
        secretAddress = iMainPage.getSecretAddress().getAttribute("textContent");
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

    @And("^I wait for write button visibility$")
    public void iWaitForWriteButtonVisibility() {
        logger.info("I wait for write button visibility");
        PageObject.waitForVisibility(iMainPage.getSendButton(), 15);
    }

    @And("^I check that send letter form is displayed$")
    public void iCheckThatLetterFormIsDisplayed() {
        logger.info("I check that send letter form is displayed");
        Assert.assertTrue(
                "Send letter form is not opened",
                iMainPage.getSendButton().isDisplayed()
        );
    }

    @And("^I fill in field To in send letter form$")
    public void iFillInFieldToInSendLetterForm() {
        logger.info("I fill in field To in send letter form");
        iMainPage.getFieldToSendForm().sendKeys(nameOfEmail);
    }

    @And("^I fill in field Subject in send letter form$")
    public void iFillInFieldSubjectInSendLetterForm() {
        logger.info("I fill in field Subject in send letter form");
        iMainPage.getFieldSubjectSendForm().sendKeys("Test");
    }

    @And("^I fill in field Text in send letter form$")
    public void iFillInFieldTextInSendLetterForm() {
        logger.info("I fill in field Text in send letter form");
        iMainPage.getFieldTextSendForm().sendKeys(secretAddress);
    }

    @And("^I click Send button$")
    public void iClickSendButton() {
        logger.info("I click Send button");
        iMainPage.getSendButton().click();
    }

    @And("^I wait for new letter$")
    public void iWaitForNewLetter() {
        logger.info("I wait for new letter");
        PageObject.waitForVisibility(iMainPage.getNewLetter(), 10).click();
    }

    @And("^I wait for letter to be opened$")
    public void iWaitForLetterToBeOpened() {
        logger.info("I wait for letter to be opened");
        PageObject.waitForVisibility(iMainPage.getDeleteMailButton(), 5);
    }

    @And("^I check that letter email matches$")
    public void iCheckThatNameOfEmailMatches() {
        logger.info("I check that nameOfEmail matches");
        Assert.assertEquals(
                "Email address dont match",
                nameOfEmail,
                iMainPage.getFieldToLetter().getText()
        );
    }

    @And("^I check that letter subject matches$")
    public void iCheckThatLetterSubjectMatches() {
        logger.info("I check that letter subject matches");
        Assert.assertEquals(
                "Email subject dont match",
                "Test",
                iMainPage.getFieldSubjectLetter().getAttribute("textContent")
        );
    }

    @And("^I check that letter text matches$")
    public void iCheckThatLetterTextMatches() {
        logger.info("I check that letter text matches");
        Assert.assertEquals(
                "Email text dont match",
                secretAddress,
                iMainPage.getFieldTextLetter().getAttribute("textContent")
        );
    }

    @And("^I click Reply button$")
    public void iClickReplyButton() {
        logger.info("I click Reply button");
        iMainPage.getReplyButton().click();
    }

    @And("^I fill in field Text in reply letter form$")
    public void iFillInFieldTextInReplyLetterForm() {
        logger.info("I fill in field Text in reply letter form");
        iMainPage.getFieldTextSendForm().sendKeys("Test2");
    }

    @And("^I wait for Main page to be opened$")
    public void iWaitForMainPageToBeOpened() {
        logger.info("I wait for Main page to be opened");
        PageObject.waitForVisibility(iMainPage.getWriteButton(), 10);
    }

    @And("^I click Back button$")
    public void iClickBackButton() {
        logger.info("I click Back button");
        PageObject.waitForVisibility(iMainPage.getBackButton(), 10).click();
    }

    @And("^I check that new letter subject matches$")
    public void iCheckThatNewLetterSubjectMatches() {
        logger.info("I check that new letter subject matches");
        Assert.assertEquals(
                "Subject does not match",
                "Re: Test",
                iMainPage.getNewLetterSubject().getAttribute("textContent")
        );
    }

    @And("^I open new letter$")
    public void iOpenNewLetter() {
        logger.info("I open new letter");
        iMainPage.getNewLetterSubject().click();
    }

    @And("^I check that new letter text matches$")
    public void iCheckThatNewLetterTextMatches() {
        logger.info("I check that new letter text matches");
        Assert.assertEquals(
                "Text does not match",
                "Test2",
                iMainPage.getFieldTextLetter().getText()
        );
    }

    @And("^I click Delete letter button$")
    public void iClickDeleteLetterButton() {
        logger.info("I click Delete letter button");
        iMainPage.getDeleteMailButton().click();
    }

    @And("^I confirm letter delete$")
    public void iConfirmLetterDelete() {
        logger.info("I confirm letter delete");
        PageObject.waitForVisibility(iMainPage.getConfirmMailDeleteButton(), 10).click();

    }

    @And("^I check that new letter is gone$")
    public void iCheckThatNewLetterIsGone() {
        logger.info("I check that new letter is gone");
        Assert.assertFalse(DriverConfig.getDriver().getPageSource().contains("Re: Test"));
    }
}
