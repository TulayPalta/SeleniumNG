package Homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Nutella_Search {
    /*
    1- Bir class oluşturun: DependsOnTest
    2- https://www.amazon.com/ adresine gidin.
    3- Test : Amazon ana sayfaya gittiginizi test edin
    4- Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin
    5- arama yapin ve aramanizin gerceklestigini Test edin
    6- Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin $16.83 oldugunu test edin
     */
    WebDriver driver;
    String dateNew;
    @BeforeMethod
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        dateNew = date.format(formatter);
        driver.get("https://wwww.amazon.com");
    }
    @AfterMethod
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.close();
    }
    @Test  //1
    public void pageAmazon() throws Exception {
        //2
        Assert.assertTrue(driver.getTitle().contains("Amazon"));
    }
    @Test (dependsOnMethods ="pageAmazon")
    public void searchBoxTest() throws Exception {
        //3
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Nutella" + Keys.ENTER);
        //4
        WebElement searchResult = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
        System.out.println(searchResult);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(searchResult.getText().contains("Nutella"));
        File nutellaSearchFile = searchResult.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(nutellaSearchFile,new File("target/screenShotWE/WESS" + dateNew +".jpeg"));
        //5
        WebElement firstItem = driver.findElement(By.xpath("(//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal'])[1]"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", firstItem);
        jse.executeScript("arguments[0].click();", firstItem);
        //6
        WebElement firstScreen = driver.findElement(By.xpath("//span[@id='productTitle']"));
        String firstItemText = "Nutella Chocolate Hazelnut Spread, Perfect Topping for Pancakes, 26.5 oz";
        softAssert.assertTrue(firstScreen.getText().contains(firstItemText));
        String expectedPrice  ="$16.83";
        String actualPrice = driver.findElement(By.xpath("(//*[@class='a-price'])[1]")).getText();
        // System.out.println(actualFiyat);
        softAssert.assertEquals(actualPrice, expectedPrice,"Price can't be matched");
        softAssert.assertAll();
    }
}