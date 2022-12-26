package day05_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class JUnitFrameWork {
    // 3 farkli test methodu olusturun
    //her bir methodun basinda driver i olusturup
    //1- amazon.com
    //2-wiseQuarter.com
    //3-Youtube.com a gidip
    //title lari yazdirin ve methoddan sonra driver i kapatin
   WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
       driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
@After
    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
}
@Test
    public void TestAmazon(){
        driver.get("https://amazon.com");
    System.out.println(driver.getTitle());
}

@Test
    public void TestwiseQuarter(){
        driver.get("https://wisequarter.com");
    System.out.println(driver.getTitle());
}
@Test
    public void TestYoutube(){
        driver.get("https://www.youtube.com");
    System.out.println(driver.getTitle());
}




}
