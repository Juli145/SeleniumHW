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
    WebElement getSecretAddress();
    WebElement getStringWaitingForNewLetters();
    WebElement getWriteButton();
    WebElement getCross();
    WebElement getSendButton();
    WebElement getFieldToSendForm();
    WebElement getFieldSubjectSendForm();
    WebElement getFieldTextSendForm();
    WebElement getNewLetter();
    WebElement getDeleteMailButton();
    WebElement getFieldToLetter();
    WebElement getFieldSubjectLetter();
    WebElement getFieldTextLetter();
    WebElement getReplyButton();
    WebElement getBackButton();
    WebElement getNewLetterSubject();
    WebElement getConfirmMailDeleteButton();
}
