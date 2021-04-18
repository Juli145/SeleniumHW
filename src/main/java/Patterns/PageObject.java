package Patterns;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Getter
public class PageObject {

    WebDriver driver;

    public PageObject() {
        PageFactory.initElements(Singleton.getDriver(), this);
    }

    @FindBy(css = "#pre_rand")
    private WebElement randomNameButton;

    @FindBy(css = "#domain")
    private WebElement dropdownDomain;

    @FindBy(xpath = "//*[@id=\"pre_form\"]/div/div[2]/div/button[6]")
    private WebElement chooseDomain;

    @FindBy(css = "#pre_button")
    private WebElement getEmail;

    @FindBy(css = "#pre_settings")
    private WebElement settingsButton;

    @FindBy(xpath = "/html/body/div[4]/div/form/div[3]/div[1]/div[2]/label[1]")
    private WebElement tenMinButton;

    @FindBy(css = "#modal-settings > div > form > div.modal-body > div:nth-child(2) > input")
    private WebElement saveButton;

    @FindBy(xpath = "/html/body/div[4]/div/form/div[2]/div/button")
    private WebElement cross;

    @FindBy(css = "#secret-address")
    private WebElement secretAddress;

    @FindBy(css = "#container-body > div > div.inbox > div > span")
    private WebElement stringWaitingForNewLetters;

    @FindBy(css = "#compose")
    private WebElement writeButton;

    @FindBy(css = "#submit")
    private WebElement sendButton;

    @FindBy(css = "#to")
    private WebElement fieldToSendForm;

    @FindBy(css = "#subject")
    private WebElement fieldSubjectSendForm;

    @FindBy(id = "text")
    private WebElement fieldTextSendForm;

    @FindBy(css = "#container-body > div > div.inbox > div.mail > div > div.from.col-9.col-md-4")
    private WebElement newLetter;

    @FindBy(css = "#delete_mail")
    private WebElement deleteMailButton;

    @FindBy(css = "#info > div.row.row-info.no-gutters > div.col.d-flex.mb-10 > span")
    private WebElement fieldToLetter;

    @FindBy(css = "#info > div.subject.mb-20")
    private WebElement fieldSubjectLetter;

    @FindBy(css = "#info > div.overflow-auto.mb-20")
    private WebElement fieldTextLetter;

    @FindBy(css = "#reply")
    private WebElement replyButton;

    @FindBy(css = "#back")
    private WebElement backButton;

    @FindBy(css = "#confirm_mail")
    private WebElement confirmMailDeleteButton;

    @FindBy(css = "#delete")
    private WebElement deleteAll_Letters;

    @FindBy(xpath = "//*[@id=\"container-body\"]/div/div[1]/div[2]/div/div[3]")
    private WebElement newLetterSubject;

    public static WebElement waitForVisibility(WebElement element, int timeOfWait, int... timeOfTryOut) {
        WebElement webElement = null;
        int timeOfRevision = timeOfTryOut.length == 0
                ? 100
                : timeOfTryOut[0];
        try {
            webElement = new WebDriverWait(Singleton.getDriver(),
                    timeOfWait,
                    timeOfRevision
            ).until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return webElement;
    }
}
