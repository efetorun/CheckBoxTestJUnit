package day02_driverMethodlar;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_Driver_Methodlari {
    public static void main(String[] args) throws InterruptedException {
        System.getProperty("webdriver.chrome.driver","C:\\Users\\Asus\\documentss\\selenium dependencies\\drivers\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println(driver.manage().window().getSize());
        Thread.sleep(3000);
       driver.manage().window().fullscreen();
        System.out.println(driver.manage().window().getSize());
        Thread.sleep(3000);

                //Browsere istedigimiz boyuta ve konumna getirelim
       driver.manage().window().setPosition(new Point(50,50));
        driver.manage().window().setSize(new Dimension(1200,540));
        Thread.sleep(3000);
        driver.quit();


    }
}
