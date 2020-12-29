import org.openqa.selenium.WebDriver;

public class HomePage extends Page {

    public HomePage(WebDriver driver) {
        /*
         * @author Nina Kumps
         */
        super(driver);
        this.getDriver().get(getPath()+"Controller?command=Index");
    }
}
