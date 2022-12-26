package day04_xpath_CssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_XPath {
    public static void main(String[] args) throws InterruptedException {
        //1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Asus\\documentss\\selenium dependencies\\drivers\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.navigate().to("https://the-internet.herokuapp.com/add_remove_elements/");
        //2- Add Element butonuna basin
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@onclick=\"addElement()\"]")).click();
        //3- Delete butonu’nun gorunur oldugunu test edin
        WebElement delete= driver.findElement(By.xpath("//button[@onclick=\"deleteElement()\"]"));
        if (delete.isDisplayed()){
            System.out.println("Delete TEsti PASSED");
        }else {
            System.out.println("Delete TEsti FAILED");
        }
//4- Delete tusuna basin
        delete.click();
        Thread.sleep(1500);
//5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin
WebElement addRemove= driver.findElement(By.xpath("//*[@id=\"content\"]/h3"));
if (addRemove.isDisplayed()){
    System.out.println("Remove Testi PASSED");
}else {
    System.out.println("Remove Testi FAILED");
}
driver.quit();




    }
}
