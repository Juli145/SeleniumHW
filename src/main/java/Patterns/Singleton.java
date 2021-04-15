package Patterns;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public  class Singleton {
    public static WebDriver driver = null;
    public static String browserName = "chrome";

    public static WebDriver getDriver(){
        if (driver == null) {
            if(browserName.equalsIgnoreCase("chrome")){
                System.setProperty("webdriver.chrome.driver",".idea/drivers/chromedriver.exe");
                driver = new ChromeDriver();
            }
        }
        return driver;
    }

    public static void initialize() {
        getDriver();
        driver.manage().window().maximize();
        driver.get("https://tempmail.plus/ru/");
    }

    public static void quit(){
        System.out.println("quitting the browser");
        driver.quit();
        driver = null;
    }
}