package Homeworks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SaucedemoPage;
import utilities.Driver;

public class saucedemoHomework {
    @Test
    public void test01() {
        //     * Navigate to  https://www.saucedemo.com/
        Driver.getDriver().get("https://www.saucedemo.com/");
        //     * Enter the username  as standard_user
        //     * Enter the password as   secret_sauce
        //     * Click on login button
        SaucedemoPage saucedemoPage = new SaucedemoPage();
        saucedemoPage.username.sendKeys("standard_user");
        saucedemoPage.password.sendKeys("secret_sauce");
        saucedemoPage.loginButton.click();
        //     * Choose price low to high
        //       and verify that PRICE (LOW TO HIGH) is visible
        WebElement ddm = saucedemoPage.dropDown;
        Select select = new Select(ddm);
        select.selectByVisibleText("Price (low to high)");
        Assert.assertTrue(saucedemoPage.dropDown.isDisplayed());
    }
}
