package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\Asus\\documentss\\selenium dependencies\\drivers\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.navigate().to("https://online.wisequarter.com/");
        Thread.sleep(4000);
        WebElement userName= driver.findElement(By.xpath("//*[@id=\"page-login-index\"]"));
        userName.sendKeys("egzy5561@gmail.com");
        WebElement password= driver.findElement(By.xpath("//*[@id=\"password\"]"));
        password.sendKeys("15Temmuz2016.");
        driver.findElement(By.xpath("//*[@id=\"loginbtn\"]")).click();
        Thread.sleep(4000);
        //driver.quit();



    }
}
