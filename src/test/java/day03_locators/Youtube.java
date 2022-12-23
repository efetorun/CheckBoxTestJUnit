package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Youtube {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Asus\\documentss\\selenium dependencies\\drivers\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.navigate().to("https://www.youtube.com/");
        Thread.sleep(4000);
        WebElement cookies= driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[6]/div[1]/ytd-button-renderer[1]/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]"));
        cookies.click();
        Thread.sleep(2000);
        WebElement aramaCubugu= driver.findElement(By.xpath("//input[@name=\"search_query\"]"));
        aramaCubugu.sendKeys("ofis müzikleri");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"search-icon-legacy\"]/yt-icon")).click();
     driver.findElement(By.xpath("//a[@aria-label=\"" +
                                              "Ofis Müzikleri-Harika-Office Music-Great Savaş Yıldız" +
                                             " tarafından 1 yıl önce 1 saat 10.134 görüntüleme\"] ")).click();
        Thread.sleep(10000);
        driver.quit();
    }
}
