package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HmcPage {

    public HmcPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[text()='Log in']")
    public WebElement loginButton;

    @FindBy(xpath = "//input[@id='UserName']")
    public WebElement usernameTextBox;

    @FindBy(xpath = "//input[@id='Password']")
    public WebElement passwordTextBox;

    @FindBy(xpath = "//input[@id='btnSubmit']")
    public WebElement loginPageLoginButton;

    @FindBy(xpath = "//span[@class='username username-hide-on-mobile']")
    public WebElement managerAfterLogin;

    @FindBy(id = "divMessageResult")
    public WebElement notLoginWarning;

    @FindBy(xpath = "//*[text()='Log in']")
    public WebElement login;
    @FindBy(xpath = "//*[@id='UserName']")
    public WebElement userName;
    @FindBy(xpath = "//*[@class='username username-hide-on-mobile']")
    public WebElement girisYapildi;

    @FindBy(xpath = "//a[@id='menuHotels']")
    public WebElement hotelManagement;

    @FindBy(xpath = "(//a[@href='/admin/RoomReservationAdmin'])[1]")
    public WebElement roomReservation;

    @FindBy(xpath = "//span[@class='hidden-480']")
    public WebElement addRoom;

    @FindBy(xpath = "//*[text()='Try again please']")
    public WebElement girisYapilamadi;

    @FindBy (xpath= "//select[@id='IDUser']")
    public WebElement idUser;

    @FindBy (xpath = "//select[@id='IDHotelRoom']")
    public WebElement hotelRoom;

    @FindBy (xpath= "//div[@class='bootbox-body']")
    public WebElement roomReservationText;

    @FindBy (xpath = "//button[@data-bb-handler='ok']")
    public WebElement okButton;


}