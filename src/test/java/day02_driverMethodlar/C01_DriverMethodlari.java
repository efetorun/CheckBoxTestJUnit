package day02_driverMethodlar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_DriverMethodlari {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\Asus\\documentss\\selenium dependencies\\drivers\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.amazon.com");
        driver.manage().window().maximize();

        //acilan sayfanin basliginin amazon icerdigini test edin
        String expectedWort="Amazon";
        String aktuellErgebniss=driver.getTitle();

        if (aktuellErgebniss.contains(expectedWort)){
            System.out.println("Title test Passed");
        }else {
            System.out.println("Title Test Failed");
            System.out.println(driver.getTitle());
        }

        //gittigimiz sayfanini URL sinin dogrulugunu test edelim

        String expectedURL="https://www.amazon.com/";
        String aktuellURL=driver.getCurrentUrl();

        if (expectedURL.equals(aktuellURL)){
            System.out.println("URL Test PASSED");
        }else {
            System.out.println("URL Test Failed");
            System.out.println(driver.getCurrentUrl());
        }

        Thread.sleep(5000);

        driver.close();



    }




}
