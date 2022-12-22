package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_ByLinkText {
    public static void main(String[] args) throws InterruptedException {
        System.getProperty("webdriver.chrome.driver","C:\\Users\\Asus\\documentss\\selenium dependencies\\drivers\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
        WebElement Sprache= driver.findElement(By.xpath("//*[@id=\"nav-main\"]/div[1]/div/div/div[3]/span[1]"));
        Thread.sleep(5000);
        Sprache.click();
        WebElement giftCard= driver.findElement(By.linkText("Gift Cards"));
        Thread.sleep(3000);
        giftCard.click();
        //istenen sayfaya gittigini test etmek icin title in Gift Card icerdiginin test edebiliriz
  String expectedWort="Gift Cards";
  String aktuellWort=driver.getTitle();


  if (aktuellWort.contains(expectedWort)){
      System.out.println("TEst PASSED");
  }else {
      System.out.println("TEst Failed");
  }
driver.quit();
    }
}
