package seleniumTesting.clothesSite;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import seleniumTesting.clothesSite.pages.DressesCategoryPage;
import seleniumTesting.clothesSite.pages.HomePage;
import seleniumTesting.clothesSite.pages.ShoppingCartSummaryPage;
import seleniumTesting.clothesSite.pages.SummerDressesProductsPage;
import java.time.Duration;

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
  void navigateToCasualDressesAndAddOneToBasketSignIn() throws InterruptedException {
    HomePage homeP = new HomePage( driver );
    homeP.navigateToSiteHomePage( "http://automationpractice.com/index.php" );
    homeP.navigateToDressesCategoriesPage();

    DressesCategoryPage dressesCategoryPage = new DressesCategoryPage( driver );
    dressesCategoryPage.navigateToSummerDressesProductsPage();

    SummerDressesProductsPage summerDressesProductsPage = new SummerDressesProductsPage( driver );

    summerDressesProductsPage.pressProductCard( 1 );

    summerDressesProductsPage.viewThumbnails();

    summerDressesProductsPage.increaseProductQuantity( 1 );
    summerDressesProductsPage.changeDressSize( 1 );
    summerDressesProductsPage.changeDressColour( 0 );
    summerDressesProductsPage.addProductToCartAndProceedToCheckout();

    ShoppingCartSummaryPage shoppingCartSummaryPage = new ShoppingCartSummaryPage( driver );
    shoppingCartSummaryPage.summaryProceedToCheckoutButton();
    shoppingCartSummaryPage.signInPageSignIn();
    shoppingCartSummaryPage.addressProceedToCheckout();
    shoppingCartSummaryPage.shippingAcceptToSAndProceedToCheckout();
    shoppingCartSummaryPage.paymentPayByCard();
  }
}
