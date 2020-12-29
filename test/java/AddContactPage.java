import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class AddContactPage extends Page{
    /*
     * @author Nina Kumps
     */
    public AddContactPage(WebDriver driver) {
        super(driver);
        this.getDriver().get(getPath()+ "Controller?command=ContactOverview");
    }

    @FindBy(id = "firstName")
    private WebElement firstNameField;

    @FindBy(id = "lastName")
    private WebElement lastNamefield;

    @FindBy(id = "date")
    private WebElement dateField;

    @FindBy(id = "hour")
    private WebElement hourField;

    @FindBy(id = "phoneNumber")
    private WebElement phoneNumberField;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(className = "signUp")
    private WebElement signUpButton;

    public void setFirstNameField(String firstName) {
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }

    public void setLastNamefield(String lastName) {
        lastNamefield.clear();
        lastNamefield.sendKeys(lastName);
    }

    public void setDateField(String date) {
        dateField.clear();
        dateField.sendKeys(date);
    }

    public void setHourField(String hour) {
        hourField.clear();
        hourField.sendKeys(hour);
    }

    public void setPhoneNumberField(String phoneNumber) {
        phoneNumberField.clear();
        phoneNumberField.sendKeys(phoneNumber);
    }

    public void setEmailField(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void submitValid() {
        signUpButton.click();
        //return PageFactory.initElements(driver, AddContactPage.class);
    }

    public boolean hasErrorMessage(String message) {
        WebElement errorMessage = driver.findElement(By.xpath("/html/body/div/main/div/ul/li"));
        return (message.equals(errorMessage.getText()));
    }

    public boolean containsFirstName(String firstName) {
        ArrayList<WebElement> listItems = (ArrayList<WebElement>) this.driver.findElements(By.cssSelector("td"));
        boolean found = false;
        for (WebElement listItem : listItems) {
            if (listItem.getText().contains(firstName)) {
                found = true;
            }
        }
        return found;
    }

    public boolean containsLastName(String lastName) {
        ArrayList<WebElement> listItems = (ArrayList<WebElement>) this.driver.findElements(By.cssSelector("td"));
        boolean found = false;
        for (WebElement listItem : listItems) {
            if (listItem.getText().contains(lastName)) {
                found = true;
            }
        }
        return found;
    }

    public boolean containsDate(String date) {
        ArrayList<WebElement> listItems = (ArrayList<WebElement>) this.driver.findElements(By.cssSelector("td"));
        boolean found = false;
        for (WebElement listItem : listItems) {
            if (listItem.getText().contains(date)) {
                found = true;
            }
        }
        return found;
    }

    public boolean containsHour(String hour) {
        ArrayList<WebElement> listItems = (ArrayList<WebElement>) this.driver.findElements(By.cssSelector("td"));
        boolean found = false;
        for (WebElement listItem : listItems) {
            if (listItem.getText().contains(hour)) {
                found = true;
            }
        }
        return found;
    }

    public boolean containsPhoneNumber(String phoneNumber) {
        ArrayList<WebElement> listItems = (ArrayList<WebElement>) this.driver.findElements(By.cssSelector("td"));
        boolean found = false;
        for (WebElement listItem : listItems) {
            if (listItem.getText().contains(phoneNumber)) {
                found = true;
            }
        }
        return found;
    }

    public boolean containsUserWithEmail(String email) {
        ArrayList<WebElement> listItems = (ArrayList<WebElement>) this.driver.findElements(By.cssSelector("td"));
        boolean found = false;
        for (WebElement listItem : listItems) {
            if (listItem.getText().contains(email)) {
                found = true;
            }
        }
        return found;
    }

    public boolean hasEmptyFirstName() {
        return firstNameField.getAttribute("value").isEmpty();
    }

    public boolean hasStickyFirstName (String firstname) {
        return firstname.equals(firstNameField.getAttribute("value"));
    }

    public boolean hasStickyLastName (String lastName) {
        return lastName.equals(lastNamefield.getAttribute("value"));
    }

    public boolean hasStickyDate (String date) {
        return date.equals(dateField.getAttribute("value"));
    }

    public boolean hasStickyHour (String hour) {
        return hour.equals(hourField.getAttribute("value"));
    }

    public boolean hasStickyPhoneNumber (String phoneNumber) {
        return phoneNumber.equals(phoneNumberField.getAttribute("value"));
    }

    public boolean hasStickyEmail (String email) {
        return email.equals(emailField.getAttribute("value"));
    }



}