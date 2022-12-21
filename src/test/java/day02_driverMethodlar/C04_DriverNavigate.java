package day02_driverMethodlar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_DriverNavigate {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Asus\\documentss\\selenium dependencies\\drivers\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.amazon.com/");
        driver.get("https://www.wisequarter.com");
        // yeniden amazon a dönelim
        driver.navigate().back();
        //tekrar wisequarter a dönelim
        driver.navigate().forward();
        Thread.sleep(4000);
        driver.quit();


    }
}
