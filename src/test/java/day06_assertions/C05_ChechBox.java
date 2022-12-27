package day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_ChechBox {
    //Create the required structure and complete the following task.
    // a. Go to the given web page.
    // https://the-internet.herokuapp.com/checkboxes
    // b. Locate the checkbox1 and checkbox2 elements.
    // c. If Checkbox1 is not selected, click the checkbox and test it is selected
    //  D. If Checkbox2 is not selected, click the checkbox and test it is selecte
    WebDriver driver;
@Before
    public void setUp(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));}

@After
    public void tearDown() throws InterruptedException {
    Thread.sleep(2000);
    driver.close();
}
@Test
public void Test01(){
    driver.get("https://the-internet.herokuapp.com/checkboxes");
    WebElement chechbx1=driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
    WebElement chechbx2=driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
if (!chechbx1.isSelected()){
    chechbx1.click();
}
    Assert.assertTrue(chechbx1.isSelected());

if (!chechbx2.isSelected()){
    chechbx2.click();

}
Assert.assertTrue(chechbx2.isSelected());
}



}