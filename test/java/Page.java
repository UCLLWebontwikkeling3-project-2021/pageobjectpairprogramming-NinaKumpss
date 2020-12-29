import org.openqa.selenium.WebDriver;

public abstract class Page {
    /*
     * @author Nina Kumps
     */
    WebDriver driver;
    String path = "http://localhost:8080/Deelopdracht4_war_exploded/";

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getPath() {
        return path;
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
