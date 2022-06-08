package seleniumTesting.clothesSite;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import seleniumTesting.clothesSite.pages.ContactUsPage;
import seleniumTesting.clothesSite.pages.HomePage;

import static org.awaitility.Awaitility.await;

public class ContactCustomerSupport {
  WebDriver driver;

  @BeforeAll
  static void setupClass() {
    WebDriverManager.firefoxdriver().setup();
  }

  @BeforeEach
  void setupTest() {
    driver = new FirefoxDriver();
  }

  @AfterEach
  void teardown() {
    if ( driver != null ) {
    }
  }

  @Test
  public void NavigateToSiteAndContactToFillTheForm() {

    HomePage homePage = new HomePage( driver );
    homePage.navigateToSiteHomePage( "http://automationpractice.com/index.php" );
    homePage.navigateToContactUsPage();

    ContactUsPage contactUsPage = new ContactUsPage( driver );
    contactUsPage.fillOutContactUsPageFormAndSubmit();
  }
}
