import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D://JuliDirectory//Selenium drivers and jars//Drivers//chromedrivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
    }
}
