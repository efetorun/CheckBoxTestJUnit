package day02_driverMethodlar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_driverManageMethodlari {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Asus\\documentss\\selenium dependencies\\drivers\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //Bu yuzkardaki dortlu her test methodunun basina yazilacaktir.....
    }
}
