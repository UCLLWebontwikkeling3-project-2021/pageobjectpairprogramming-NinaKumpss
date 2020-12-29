
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

/**
 * @author Nina Kumps
 */

public class LogInPage extends Page {
       @FindBy(id="userId")
    private WebElement userIdField;

    @FindBy(id="password")
    private WebElement passwordField;

    @FindBy(className="signUp")
    private WebElement signUpButton;


    public LogInPage(WebDriver driver) {
        super(driver);
        this.getDriver().get(getPath() + "Controller?command=Index");
    }

    public void setUserId(String userId) {
        userIdField.clear();
        userIdField.sendKeys(userId);
    }

    public void setPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public HomePage submitValid() {
        signUpButton.click();
        return PageFactory.initElements(driver, HomePage.class);
    }

    public void submitInvalid() {
        signUpButton.click();
    }

    public boolean hasErrorMessage(String message) {
        WebElement errorMessage = driver.findElement(By.xpath("/html/body/div/main/div/ul/li"));
        return message.equals(errorMessage.getText());
    }

    public boolean previousUserId(String userId) {
        return userId.equals(userIdField.getAttribute("value"));
    }

    public boolean userIdIsEmpty() {
        return userIdField.getAttribute("value").isEmpty();
    }

    public void loginUser() {
        setUserId("nina");
        setPassword("test");
        submitValid();
    }
}
