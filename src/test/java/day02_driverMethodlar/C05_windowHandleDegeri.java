package day02_driverMethodlar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05_windowHandleDegeri {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Asus\\documentss\\selenium dependencies\\drivers\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println(driver.getWindowHandle());//CDwindow-74E5CD6E38DAB1E9B286408297DA0F42 unique bir degerdir
        driver.get("https://www.amazon.com/");
        driver.quit();

        driver=new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println(driver.getWindowHandle());
        driver.get("https://www.wisequarter.com/");

        Thread.sleep(4000);
        driver.quit();

    }
}
