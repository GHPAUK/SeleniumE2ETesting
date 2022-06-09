package seleniumTesting.clothesSite;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import seleniumTesting.clothesSite.pages.*;
import java.time.Duration;

@Disabled
public class ClothesSiteTest {
  WebDriver driver;

  @BeforeAll
  static void setupClass() {
    WebDriverManager.firefoxdriver().setup();
  }

  @BeforeEach
  void setupTest() {
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait( Duration.ofSeconds( 20 ) );
  }

  @AfterEach
  void teardown() {
    if ( driver != null ) {
//      driver.quit();
    }
  }

  @Test
  void loginNavToMyAccountAndChangePassword() {
    HomePage homeP = new HomePage( driver );
    homeP.navigateToSiteHomePage( "http://automationpractice.com/index.php" );
    homeP.navigateToAuthenticationSignInPage();

    AuthenticationPage authenticationPage = new AuthenticationPage( driver );
    authenticationPage.signInPageFillDetailsAndLogIn();

    MyAccountPage myAccountPage = new MyAccountPage( driver );
    myAccountPage.navigateToMyPersonalDetailsPage();
    myAccountPage.changePasswordAndSubmit();
  }
}
