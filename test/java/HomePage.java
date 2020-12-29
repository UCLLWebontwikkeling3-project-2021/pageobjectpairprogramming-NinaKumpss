import org.openqa.selenium.WebDriver;

/**
 * @author Nina Kumps
 */

public class HomePage extends Page {
    public HomePage(WebDriver driver) {
        super(driver);
        this.getDriver().get(getPath()+"Controller?command=Index");
    }
}
