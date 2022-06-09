package seleniumTesting.clothesSite.cucumbertests.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import seleniumTesting.clothesSite.pages.*;

public class ClothesShopSiteBuyADressStepDefinitions {
  WebDriver driver;

  @Before
  public void setup() {
    WebDriverManager.firefoxdriver().setup();
    driver = new FirefoxDriver();
  }

  @After
  public void quitWebDriver( Scenario scenario ) {
    if (scenario.isFailed()){
      final byte[] screenshot = ( ( TakesScreenshot ) driver ).getScreenshotAs( OutputType.BYTES );
      scenario.attach( screenshot, "image/png", scenario.getName() + " screenshot" );
    }
    driver.quit();
  }

  @Given( "I have navigated to the sites dresses products page" )
  public void iHaveNavigatedToTheSitesDressesProductsPage() {
    HomePage homeP = new HomePage( driver );
    homeP.navigateToSiteHomePage( "http://automationpractice.com/index.php" );
    homeP.navigateToDressesCategoriesPage();
    DressesCategoryPage dressesCategoryPage = new DressesCategoryPage( driver );
    dressesCategoryPage.navigateToSummerDressesProductsPage();
  }

  @And( "I have added a chosen dress to my basket" )
  public void iHaveAddedAChosenDressToMyBasket() {
    SummerDressesProductsPage summerDressesProductsPage = new SummerDressesProductsPage( driver );
    summerDressesProductsPage.pressProductCard( 1 );
    summerDressesProductsPage.viewThumbnails();
    summerDressesProductsPage.increaseProductQuantity( 1 );
    summerDressesProductsPage.changeDressSize( 1 );
    summerDressesProductsPage.changeDressColour( 0 );
    summerDressesProductsPage.addProductToCartAndProceedToCheckout();
  }


  @When( "I proceed to checkout, input all my details and confirm payment" )
  public void iProceedToCheckoutInputAllMyDetailsAndConfirmPayment() {
    ShoppingCartSummaryPage shoppingCartSummaryPage = new ShoppingCartSummaryPage( driver );
    shoppingCartSummaryPage.summaryProceedToCheckoutBtn();
    AuthenticationPage authenticationPage = new AuthenticationPage( driver );
    authenticationPage.signInPageFillDetailsAndLogIn();
    shoppingCartSummaryPage.addressProceedToCheckout();
    shoppingCartSummaryPage.shippingAcceptToSAndProceedToCheckout();
  }


  @Then( "I will receive a purchase successful confirmation notification" )
  public void iWillReceiveAPurchaseSuccessfulConfirmationNotification() {
    ShoppingCartSummaryPage shoppingCartSummaryPage = new ShoppingCartSummaryPage( driver );
    shoppingCartSummaryPage.paymentPayByCard();
  }
}
