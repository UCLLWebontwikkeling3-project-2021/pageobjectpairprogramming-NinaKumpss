import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.*;

public class AddContactTest {
    /*
     * @author Nina Kumps
     */

    private WebDriver driver;
    private String path = "http://localhost:8080/Deelopdracht4_war_exploded/";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ninak\\OneDrive\\Documenten\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(path + "Controller?command=Index");
    }
/*
    @After
    public void clean() {
        driver.quit();
    }*/

    @Test
    public void test_log_in() {
        LogInPage loginPage = PageFactory.initElements(driver, LogInPage.class);
        loginPage.loginUser();
        assertEquals("Home", loginPage.getTitle());
    }

    @Test
    public void test_user_can_add_contact() {
        LogInPage logInPage = PageFactory.initElements(driver, LogInPage.class);
        logInPage.loginUser();

        AddContactPage addContactPage = PageFactory.initElements(driver, AddContactPage.class);

        addContactPage.setFirstNameField("Mark");
        addContactPage.setLastNamefield("Walberg");
        addContactPage.setDateField("11-11-2020");
        addContactPage.setHourField("08:55");
        addContactPage.setPhoneNumberField("0412456512");
        addContactPage.setEmailField("mark@ucll.be");

        addContactPage.submitValid();
        assertEquals("Contacts", addContactPage.getTitle());
        addContactPage.setFirstNameField("Mark");
        addContactPage.setLastNamefield("Walberg");
        assertTrue(addContactPage.containsDate("11/11/2020"));
        assertTrue(addContactPage.containsHour("08:55"));
        assertTrue(addContactPage.containsPhoneNumber("0412456512"));
        assertTrue(addContactPage.containsUserWithEmail("mark@ucll.be"));
    }

    @Test
    public void test_user_fills_in_empty_firstname() {
        LogInPage logInPage = PageFactory.initElements(driver, LogInPage.class);
        logInPage.loginUser();

        AddContactPage addContactPage = PageFactory.initElements(driver, AddContactPage.class);

        addContactPage.setFirstNameField("");
        addContactPage.setLastNamefield("Walberg");
        addContactPage.setDateField("11-11-2020");
        addContactPage.setHourField("08:55");
        addContactPage.setPhoneNumberField("0412456512");
        addContactPage.setEmailField("mark@ucll.be");
        addContactPage.submitValid();

        assertEquals("Contacts", addContactPage.getTitle());
        assertTrue(addContactPage.hasErrorMessage("No firstName is given"));
    }

    @Test
    public void test_user_fills_in_empty_lastname() {
        LogInPage logInPage = PageFactory.initElements(driver, LogInPage.class);
        logInPage.loginUser();

        AddContactPage addContactPage = PageFactory.initElements(driver, AddContactPage.class);

        addContactPage.setFirstNameField("Mark");
        addContactPage.setLastNamefield("");
        addContactPage.setDateField("11-11-2020");
        addContactPage.setHourField("08:55");
        addContactPage.setPhoneNumberField("0412456512");
        addContactPage.setEmailField("mark@ucll.be");
        addContactPage.submitValid();

        assertEquals("Contacts", addContactPage.getTitle());
        assertTrue(addContactPage.hasErrorMessage("No lastName is given"));
    }
    @Test
    public void test_user_fills_in_empty_date() {
        LogInPage logInPage = PageFactory.initElements(driver, LogInPage.class);
        logInPage.loginUser();

        AddContactPage addContactPage = PageFactory.initElements(driver, AddContactPage.class);

        addContactPage.setFirstNameField("Mark");
        addContactPage.setLastNamefield("Walberg");
        addContactPage.setDateField("");
        addContactPage.setHourField("08:55");
        addContactPage.setPhoneNumberField("0412456512");
        addContactPage.setEmailField("mark@ucll.be");
        addContactPage.submitValid();

        assertEquals("Contacts", addContactPage.getTitle());
        assertTrue(addContactPage.hasErrorMessage("No valid date is given"));
    }

    @Test
    public void test_user_fills_in_empty_hour() {
        LogInPage logInPage = PageFactory.initElements(driver, LogInPage.class);
        logInPage.loginUser();

        AddContactPage addContactPage = PageFactory.initElements(driver, AddContactPage.class);

        addContactPage.setFirstNameField("Mark");
        addContactPage.setLastNamefield("Walberg");
        addContactPage.setDateField("11-11-2020");
        addContactPage.setHourField("");
        addContactPage.setPhoneNumberField("0412456512");
        addContactPage.setEmailField("mark@ucll.be");
        addContactPage.submitValid();

        assertEquals("Contacts", addContactPage.getTitle());
        assertTrue(addContactPage.hasErrorMessage("No valid hour given"));
    }

    @Test
    public void test_user_fills_in_empty_phonenumber() {
        LogInPage logInPage = PageFactory.initElements(driver, LogInPage.class);
        logInPage.loginUser();

        AddContactPage addContactPage = PageFactory.initElements(driver, AddContactPage.class);

        addContactPage.setFirstNameField("Mark");
        addContactPage.setLastNamefield("Walberg");
        addContactPage.setDateField("11-11-2020");
        addContactPage.setHourField("08:55");
        addContactPage.setPhoneNumberField("");
        addContactPage.setEmailField("mark@ucll.be");
        addContactPage.submitValid();

        assertEquals("Contacts", addContactPage.getTitle());
        assertTrue(addContactPage.hasErrorMessage("No phoneNumber is given"));
    }

    @Test
    public void test_user_fills_in_empty_email() {
        LogInPage logInPage = PageFactory.initElements(driver, LogInPage.class);
        logInPage.loginUser();

        AddContactPage addContactPage = PageFactory.initElements(driver, AddContactPage.class);

        addContactPage.setFirstNameField("Mark");
        addContactPage.setLastNamefield("Walberg");
        addContactPage.setDateField("11-11-2020");
        addContactPage.setHourField("08:55");
        addContactPage.setPhoneNumberField("0412456512");
        addContactPage.setEmailField("");
        addContactPage.submitValid();

        assertEquals("Contacts", addContactPage.getTitle());
        assertTrue(addContactPage.hasErrorMessage("No email given"));
    }
}