package Patterns;

import org.junit.*;
import org.openqa.selenium.WebElement;


public class AutoTestHW {

    @BeforeClass
    public static void setUp(){
        Singleton.initialize();
    }

    @Test
    public void test_checkFunctional() throws InterruptedException {
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
        po.getCross().click();
        // 3.7
        WebElement element = PageObject.waitForVisibility(po.getDropdownDomain(), 5);
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

    }

    @AfterClass
    public static void tearDown(){
        Singleton.quit();
    }
}

