package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_ByClassName {
    public static void main(String[] args) throws InterruptedException {
        System.getProperty("webdriver.chrome.driver","C:\\Users\\Asus\\documentss\\selenium dependencies\\drivers\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
        WebElement aramaKutusu= driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        List<WebElement>fiyatlar=driver.findElements(By.className("a-price-whole"));
        // web elemnt bir obje oldugundan direk yazdiralamaz

        //bunun icin for each loop ile her bbir web element üzerindeki
        //yazilari tek tek yazdirmaliyiz

        for (WebElement each:fiyatlar
             ) {
            System.out.println(each.getText());
        }
       String fiyat="";
        int fiyati;
        int max=0;
        for (WebElement each:fiyatlar
        ) {
            System.out.println(each.getText());
            fiyat= each.getText();
            fiyati=Integer.parseInt(fiyat);
            if (fiyati>max){
                max=fiyati;
            }
        }
        System.out.println("en büyük fiyat = " +max);
        
        // System.out.println(fiyatlar);
        Thread.sleep(4000);
        driver.quit();


    }
}
