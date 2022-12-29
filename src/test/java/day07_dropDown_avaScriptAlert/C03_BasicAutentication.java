package day07_dropDown_avaScriptAlert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BasicAutentication {
    // 1- Bir class olusturun : BasicAuthentication
    //2- https://the-internet.herokuapp.com/basic_auth sayfasina gidin
    //3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin

    //Html komutu : https://username:password@URL
    //  Username     : admin
    //  password      : admin
    //
     //   driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
    //4- Basarili sekilde sayfaya girildigini dogrulayin
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();

    }
@Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/basic_auth");

    //Html komutu : https://username:password@URL
    //  Username     : admin
    //  password      : admin
    driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
    //4- Basarili sekilde sayfaya girildigini dogrulayin
    String actualSonucYazisi=driver.findElement(By.xpath("//*[@id=\"content\"]/div/p")).getText();
   String expectedSonucYazisi="Congratulations! You must have the proper credentials.";

    Assert.assertEquals(expectedSonucYazisi,actualSonucYazisi);
    }

}
