package day08_HandlingWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C03_WindowHandle {
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
    // https://the-internet.herokuapp.com/iframe adresine gidin
    driver.get("https://the-internet.herokuapp.com/iframe");
    // elemental selenium linkini tiklayin
    // linke tikladigimizda yeni sayfa acilacagindan
    // click yapmadan once ilk sayfanin WHD'ini alip kaydedelim
    String IlksayfaWhd= driver.getWindowHandle();
    driver.findElement(By.xpath("(//a[@target=\"_blank\"])[2]")).click();
    // click yapinca yeni tab acilir ancak driver eski tab'da kalir
    // yeni tab'a driver'i gecirmek icin yeni tab'in WHD ihtiyacimiz var
    Set<String>TumWindowHandles=driver.getWindowHandles();
    String ikinciSayfaWhd="";
    for (String each:TumWindowHandles)
    {  if (!each.equals(IlksayfaWhd)){
        ikinciSayfaWhd=each;
    }

    }
    // foreach loop bittiginde ikinci sayfanin WHD'ini elde etmis olacagiz
    // bu degeri kullanarak, driver'i 2.sayfaya  gecirebiliriz
    driver.switchTo().window(ikinciSayfaWhd);
    Thread.sleep(3000);
// yeni tab'a gecip sayfadaki en buyuk yazinin "Elemental Selenium" oldugunu test edin
    String actualSayfaYazisi=driver.findElement(By.xpath("//h1[text()='Elemental Selenium']")).getText();
    String expectedSayfaYazsi="Elemental Selenium";
    Assert.assertEquals(expectedSayfaYazsi,actualSayfaYazisi);
    // ilk sayfaya geri donup sayfadaki yazinin
    // "An iFrame containing the TinyMCE WYSIWYG Editor" oldugunu test edin
    driver.switchTo().window(IlksayfaWhd);
    String expectedSayfaYazisiSon="An iFrame containing the TinyMCE WYSIWYG Editor";
    String actualSayfaYazisiSon=driver.findElement(By.xpath("//h3[text()='An iFrame containing the TinyMCE WYSIWYG Editor']")).getText();
    Assert.assertEquals(expectedSayfaYazisiSon,actualSayfaYazisiSon);


    }


}
