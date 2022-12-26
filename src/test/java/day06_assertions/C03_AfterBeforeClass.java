package day06_assertions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.core5.util.Asserts;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
public class C03_AfterBeforeClass {
    //3 ayri test methodu olusturun
    //1.Method amazon a gidip amazona gittigimizi test edin
    //2.method da amazonda nutella aratip sonuclarin nutella icerdiginin test edin
    //3.method da nutella arama sonuc sayisinin 50 den fazla oldugunun test edin
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void Test1() {
        driver.get("https://www.amazon.com/");
    }

    @Test
    public void Test2() throws InterruptedException {




        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        String expectedWort = "Nutella";
        String actuel = driver.findElement(By.xpath("//span[@class=\"a-color-state a-text-bold\"]")).getText();
        Assert.assertTrue(actuel.contains(expectedWort));
    }

    @Test
    public void Test3() throws InterruptedException {

        String resultsforNutella=driver.findElement(By.xpath("//div[@class=\"a-section a-spacing-small a-spacing-top-small\"]")).getText();
        System.out.println(resultsforNutella);
        String[] resultArr=resultsforNutella.split(" ");
        String lastResult=resultArr[2];
        int lastresultInt;
        lastresultInt=Integer.parseInt(lastResult);
        Assert.assertTrue(lastresultInt>50);
        System.out.println(lastresultInt);

    }
















}
