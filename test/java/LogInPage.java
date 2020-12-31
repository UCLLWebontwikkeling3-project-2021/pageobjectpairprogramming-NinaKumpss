
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public void submitValid() {
        signUpButton.click();
        //return PageFactory.initElements(driver, HomePage.class);
    }

    public void loginUser() {
        setUserId("nina");
        setPassword("test");
        submitValid();
    }
}
