package day02_driverMethodlar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_DriverfindElements {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Asus\\documentss\\selenium dependencies\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
        WebElement toolbar =driver.findElement(By.id("twotabsearchtextbox"));
        toolbar.sendKeys("Batman");
        Thread.sleep(1000);
        toolbar.clear();
        toolbar.sendKeys("efe");
        toolbar.submit();//enter a bas


        Thread.sleep(4000);

        driver.quit();




    }
}
