package day04_xpath_CssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;

import java.time.Duration;

public class C02_CssSelector {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Asus\\documentss\\selenium dependencies\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //2- https://www.amazon.com/ adresine gidin
        driver.navigate().to("https://www.amazon.com/ ");
//3- Browseri tam sayfa yapin
        driver.manage().window().maximize();
//4- Sayfayi “refresh” yapin
        driver.navigate().refresh();
//5- Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        String expectedKelime="Spend less";
        String AktuellKelime=driver.getTitle();
        if (AktuellKelime.contains(expectedKelime)){
            System.out.println("IFADE Test PASSED");
        }else {
            System.out.println("IFADE Test FAILED");
        }
//6- Gift Cards sekmesine basin
        driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[3]")).click();
//7- Birthday butonuna basin
        driver.findElement(By.xpath("//*[@id=\"contentGrid_446174\"]/div/div[2]/div[2]/div/div/a")).click();
//8- Best Seller bolumunden ilk urunu tiklayin
driver.findElement(By.xpath("//*[@id=\"acs-product-block-0\"]/div[1]/a/img"));
//9- Gift card details’den 25 $’i secin
//10-Urun ucretinin 25$ oldugunu test edin
//11-Sayfayi kapatin





    }
}
