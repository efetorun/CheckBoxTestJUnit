package day01_driverMethodlar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_driver_get {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\Asus\\documentss\\selenium dependencies\\drivers\\chromedriver.exe");

        WebDriver driver=new ChromeDriver();

        driver.get("https://www.amazon.com");
        Thread.sleep(4000);
        driver.close();






    }
}
