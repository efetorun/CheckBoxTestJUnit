package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C04_Exercise {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Asus\\documentss\\selenium dependencies\\drivers\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.automationexercise.com/");
        //sayfada 147 tane link oldugunu dogrulayin
        List<WebElement> linkListesi=driver.findElements(By.tagName("a"));
        if (linkListesi.size()==147){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }
//product linkine tiklayin
        WebElement products= driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a"));
        products.click();
        Thread.sleep(4000);
        WebElement specialOffer= driver.findElement(By.xpath("//*[@id=\"sale_image\"]"));
       Thread.sleep(3000);
        if (specialOffer.isDisplayed()){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }

    driver.quit();
    }

}
