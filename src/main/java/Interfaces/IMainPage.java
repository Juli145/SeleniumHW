package Interfaces;

import org.openqa.selenium.WebElement;
import org.w3c.dom.html.HTMLInputElement;

public interface IMainPage extends IPage{
    WebElement getRandomNameButton();
    WebElement getDropdownDomain();
    WebElement getChooseDomain();
    WebElement getGetEmail();
    WebElement getSettingsButton();
    WebElement getTenMinButton();
    static void waitForVisibility(WebElement tenMinButton, int i) {
    }
    WebElement getSecretAddress();
    WebElement getStringWaitingForNewLetters();
    WebElement getWriteButton();
    WebElement getCross();
}
