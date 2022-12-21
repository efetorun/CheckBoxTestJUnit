package day02_driverMethodlar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_driverMethodlari {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Asus\\documentss\\selenium dependencies\\drivers\\chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
       // System.out.println(driver.getPageSource());


        //pagesource nin MEOW icerdiginin test edelim
        String pageSource= driver.getPageSource();
        String expectedWort="MEOW";

        if (pageSource.contains("MEOW")){
            System.out.println("MEOW enthalt Test PASSED");
        }else {
            System.out.println("MEOW enthalt nicth also Test FAILED ");
        }
        Thread.sleep(4000);
        driver.quit();


    }

}
