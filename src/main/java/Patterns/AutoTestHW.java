package Patterns;

import org.junit.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class AutoTestHW {

    Actions action = new Actions(Singleton.getDriver());

    @BeforeClass
    public static void setUp(){
        Singleton.initialize();
    }

    @Test
    public void test_checkFunctional(){
        PageObject po = new PageObject();
        // 3.2
        po.getRandomNameButton().click();
        // 3.3
        po.getDropdownDomain().click();
        po.getChooseDomain().click();
        // 3.4
        String nameOfEmail = po.getGetEmail().getAttribute("value") + "@rover.info";
        // 3.5
        po.getSettingsButton().click();
        PageObject.waitForVisibility(po.getTenMinButton(), 5);
        po.getSaveButton().click();
        // 3.6
        String secretAddress = po.getSecretAddress().getAttribute("textContent");
        PageObject.waitForVisibility(po.getCross(), 10);
        action.moveByOffset(10, 10).click().build().perform();
        // 3.7
        WebElement element = PageObject.waitForVisibility(po.getStringWaitingForNewLetters(), 10);
        Assert.assertTrue(
                "Dropdown is not visible",
                element.isDisplayed()
        );
        // 3.8
        Assert.assertEquals(
                "Waiting for letters is not visible",
                "В ожидании новых писем...",
                po.getStringWaitingForNewLetters().getAttribute("textContent")
        );
        // 3.9
        po.getWriteButton().click();
        // 3.10
        PageObject.waitForVisibility(po.getSendButton(), 10);
        Assert.assertTrue(
                "Send letter form is not opened",
                po.getSendButton().isDisplayed()
        );
        po.getFieldToSendForm().sendKeys(nameOfEmail);
        po.getFieldSubjectSendForm().sendKeys("Test");
        po.getFieldTextSendForm().sendKeys(secretAddress);
        // 3.11
        po.getSendButton().click();
        // 3.12
        PageObject.waitForVisibility(po.getNewLetter(), 10).click();
        // 3.13
        PageObject.waitForVisibility(po.getDeleteMailButton(), 5);
        Assert.assertEquals(
                "Email address dont match",
                nameOfEmail,
                po.getFieldToLetter().getAttribute("textContent")
        );
        Assert.assertEquals(
                "Email subject dont match",
                "Test",
                po.getFieldSubjectLetter().getAttribute("textContent")
        );
        Assert.assertEquals(
                "Email text dont match",
                secretAddress,
                po.getFieldTextLetter().getAttribute("textContent")
        );
        // 3.14
        po.getReplyButton().click();
        PageObject.waitForVisibility(po.getSendButton(), 10);
        po.getFieldTextSendForm().sendKeys("Test2");
        po.getSendButton().click();
        // 3.15
        PageObject.waitForVisibility(po.getBackButton(), 10).click();
        // 3.16
    }

//    @AfterClass
//    public static void tearDown(){
//        Singleton.quit();
//    }
}

