package Homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseBeforeClassAfterClass;

public class JsExecutor extends TestBaseBeforeClassAfterClass {

        //hotelmycamp anasayfasina gidin
        //2 farkli test method’u olusturarak actions classi ve Js Executor kullanarak asagidaki oda turlerinden  ust sira ortadaki odayi tiklayin
        //istediginiz oda inceleme sayfasi acildigini test  edin

    @Test
    public void actionTest() {
        driver.get("https://hotelmycamp.com");
        //action class
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

        driver.findElement(By.xpath("(//*[@class='btn-custom'])[2]")).click();

        Assert.assertTrue(driver.getTitle().contains("dsafsaf"));

    }

    @Test
    public void jsExecutorTest() {
        driver.get("https://hotelmycamp.com");

        WebElement customButton =driver.findElement(By.xpath("(//*[@class='btn-custom'])[2]"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].scrollIntoView(true);",customButton);

        jse.executeScript("arguments[0].click();",customButton);

        Assert.assertTrue(driver.getTitle().contains("dsafsaf"));
    }
}