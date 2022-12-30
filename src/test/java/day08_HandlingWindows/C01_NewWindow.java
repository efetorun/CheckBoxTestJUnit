package day08_HandlingWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_NewWindow {
/*
Selenium 4 ile windows konusundda yeni bir özellik geldi

istersek kontrollu olarak driver icin yeni bier window veya tab olusturrabiliriz
Bu durumda driver imiz da otomatik olarak yeni sayfaya gecmis olur

Testin ilerleyen asamalarinda yeniden eski sayfalara ndonus gorevi varsa
o sayfada iken sayfanin window Handle #degeri alinip kaydedilier
ve o sayfaya gecmek istendiginde
driver.switchTo().window(IsteneSayfaninWindowHandleDegeri)
kodu ile o sayfaya gecis yapilir

 */
    WebDriver driver;
@Before
    public void setUp(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
}
@After
    public void tearDown(){
    driver.quit();
}
    @Test
    public void test01() throws InterruptedException {
driver.get("https://www.amazon.com/");
    Thread.sleep(3000);
    // testin ilerleyen asamalirinda yeniden amazon sayfasina dönmek gerekiyorsa
        //bu window un window handle degerini alip kaydetmeliyiz

        String ilkSayfaWindowHandleDegeri= driver.getWindowHandle();

    // yeni bir tab da wisequarter.com a gidin ve gittigimizi test edelim
      driver.switchTo().newWindow(WindowType.TAB);
       driver.get("https://www.wisequarter.com");
       String actualUrl=driver.getCurrentUrl();
       String expectedUrl="wisequarter";
        Assert.assertTrue(actualUrl.contains(expectedUrl));
        //wisequarter testini yaptiktan sonra
        //yeniden amozon un acik oldugu tab a gecin
        //ve amazon anasayfasininin acik oldugunu test edin
        driver.switchTo().window(ilkSayfaWindowHandleDegeri);
        actualUrl=driver.getCurrentUrl();
        expectedUrl="amazon";
        Assert.assertTrue(actualUrl.contains(expectedUrl));
        Thread.sleep(3000);
    }

}
