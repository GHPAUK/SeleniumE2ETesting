package seleniumTesting.clothesSite.cucumbertests.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import seleniumTesting.clothesSite.pages.AuthenticationPage;
import seleniumTesting.clothesSite.pages.HomePage;
import seleniumTesting.clothesSite.pages.MyAccountPage;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class ChangePassword {

  private WebDriver driver;

  @Before
  public void setupWebDriver() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait( ( Duration.ofSeconds( 10 ) ) );
  }

  @After
  public void quitWebDriver() {
    driver.quit();
  }

  @Given( "^the user clicks change password$" )
  public void theUserClicksChangePassword() {
    HomePage homeP = new HomePage( driver );
    homeP.navigateToSiteHomePage( "http://automationpractice.com/index.php" );
    homeP.navigateToAuthenticationSignInPage();
  }

  @When( "^the user changes their password$" )
  public void theUserChangesTheirPassword() {
    AuthenticationPage authenticationPage = new AuthenticationPage( driver );
    authenticationPage.signInPageFillDetailsAndLogIn();

    MyAccountPage myAccountPage = new MyAccountPage( driver );
    myAccountPage.navigateToMyPersonalDetailsPage();
    myAccountPage.changePasswordAndSubmit();
  }

  @Then( "^the password has been changed$" )
  public void thePasswordHasBeenChanged() {
    assertThat( driver.getPageSource() ).contains( "The password you entered is incorrect." );
  }
}
