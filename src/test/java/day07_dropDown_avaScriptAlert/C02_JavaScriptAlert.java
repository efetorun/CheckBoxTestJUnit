package day07_dropDown_avaScriptAlert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_JavaScriptAlert {
//Gerekli ayarlamalari yapipi
    //https://the-internet.herokuapp.com/javascript_alerts
    //3 test method u olusturup her metho da bir JsAlert e basin
    //ilgili methodlari kullanin
static WebDriver driver;

@BeforeClass
    public static void setUp(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    driver.get("https://the-internet.herokuapp.com/javascript_alerts");
}
@AfterClass
    public static void tearDown() throws InterruptedException {
    Thread.sleep(3000);
    driver.close();
}
@Test
    public void test01(){
    //Js Alert e tiklayalim
    WebElement jsAlert= driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
    jsAlert.click();
    //Alert teki yazinin "I am a JS Alert" oldugunu test edelim
    String ActualalertYazisi=driver.switchTo().alert().getText();
    System.out.println(ActualalertYazisi);
    String expectedAlertYazisi="I am a JS Alert";
    Assert.assertEquals(expectedAlertYazisi,ActualalertYazisi);
   //Ok deyip Alert i kapatalim
    driver.switchTo().alert().accept();
}
    @Test
    public void test02(){
//"2.Alert e tiklayalim

        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        // Cancel e basip cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        driver.switchTo().alert().dismiss();

        String actualAlert2Yazisi=driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedAlert2Yazisi="You clicked: Cancel";
        Assert.assertEquals(expectedAlert2Yazisi,actualAlert2Yazisi);

    }
    @Test
    public void test03() throws InterruptedException {
//3 .Alert e tiklayalim
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        //Java yazisini alerte yazdiralim
        driver.switchTo().alert().sendKeys("Java");
        Thread.sleep(1500);
        //Alert i accept edelim
        driver.switchTo().alert().accept();
        // "You entered: Java" sonuc yazisinin ciktigini test edelim
        String actualAlert3Yazisi=driver.findElement(By.xpath("//p[@id=\"result\"]")).getText();
        String expectedAlert3Yazisi="You entered: Java";
        System.out.println(actualAlert3Yazisi);
        Assert.assertEquals(expectedAlert3Yazisi,actualAlert3Yazisi);
    }
}
