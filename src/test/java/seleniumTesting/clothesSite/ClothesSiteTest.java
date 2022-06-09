package seleniumTesting.clothesSite;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import seleniumTesting.clothesSite.pages.*;

import java.time.Duration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
  void navigateToCasualDressesAndAddOneToBasketSignIn() {
    HomePage homeP = new HomePage( driver );
    homeP.navigateToSiteHomePage( "http://automationpractice.com/index.php" );
    assertThat(driver.getTitle()).isEqualTo( "My Store" );
    homeP.navigateToDressesCategoriesPage();
    assertThat(driver.getTitle()).isEqualTo( "Dresses - My Store" );

    DressesCategoryPage dressesCategoryPage = new DressesCategoryPage( driver );
    dressesCategoryPage.navigateToSummerDressesProductsPage();
    assertThat(driver.getTitle()).isEqualTo( "Summer Dresses - My Store" );

    SummerDressesProductsPage summerDressesProductsPage = new SummerDressesProductsPage( driver );

    summerDressesProductsPage.pressProductCard( 1 );

    summerDressesProductsPage.viewThumbnails();

    summerDressesProductsPage.increaseProductQuantity( 1 );
    summerDressesProductsPage.changeDressSize( 1 );
    summerDressesProductsPage.changeDressColour( 0 );
    summerDressesProductsPage.addProductToCartAndProceedToCheckout();

    ShoppingCartSummaryPage shoppingCartSummaryPage = new ShoppingCartSummaryPage( driver );
    shoppingCartSummaryPage.summaryProceedToCheckoutBtn();

    AuthenticationPage authenticationPage = new AuthenticationPage( driver );
    authenticationPage.signInPageFillDetailsAndLogIn();

    shoppingCartSummaryPage.addressProceedToCheckout();
    shoppingCartSummaryPage.shippingAcceptToSAndProceedToCheckout();
    shoppingCartSummaryPage.paymentPayByCard();
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
