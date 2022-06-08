package seleniumTesting.clothesSite.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class ShoppingCartSummaryPage {
  WebDriver driver;

  public ShoppingCartSummaryPage( WebDriver driver ) {
    this.driver = driver;
  }

  public void summaryProceedToCheckoutButton() {
    await().atMost( 20, TimeUnit.SECONDS )
            .with()
            .pollInterval( 250, TimeUnit.MILLISECONDS )
            .pollDelay( 500, TimeUnit.MILLISECONDS )
            .until( () -> driver.findElement( By.className( "cart_navigation" ) )
                    .findElement( By.className( "button" ) ).isDisplayed() );

    driver.findElement( By.className( "cart_navigation" ) )
            .findElement( By.className( "button" ) ).click();
  }

  public void signInPageSignIn() {
    await().atMost( 20, TimeUnit.SECONDS )
            .with()
            .pollInterval( 250, TimeUnit.MILLISECONDS )
            .pollDelay( 500, TimeUnit.MILLISECONDS )
            .until( () -> driver.findElement( By.id( "email" ) ).isDisplayed() );

    driver.findElement( By.id( "email" ) ).sendKeys( "testingTesting123@test.com" );

    driver.findElement( By.id( "passwd" ) ).sendKeys( "SuperSafe1" );

    driver.findElement( By.id( "SubmitLogin" ) ).click();
  }

  public void addressProceedToCheckout() {
    await().atMost( 20, TimeUnit.SECONDS )
            .with()
            .pollInterval( 250, TimeUnit.MILLISECONDS )
            .pollDelay( 500, TimeUnit.MILLISECONDS )
            .until( () -> driver.findElement( By.className( "cart_navigation" ) ).findElements( By.className( "button" ) ).get( 1 ).isDisplayed() );

    driver.findElement( By.className( "cart_navigation" ) ).findElements( By.className( "button" ) ).get( 1 ).click();
  }

  public void shippingAcceptToSAndProceedToCheckout() {
    await().atMost( 20, TimeUnit.SECONDS )
            .with()
            .pollInterval( 250, TimeUnit.MILLISECONDS )
            .pollDelay( 500, TimeUnit.MILLISECONDS )
            .until( () -> driver.findElement( By.id( "cgv" ) ).isDisplayed() );

    driver.findElement( By.id( "cgv" ) ).click();
    driver.findElement( By.className( "cart_navigation" ) ).findElements( By.className( "button" ) ).get( 1 ).click();
  }

  public void paymentPayByCard() {
    await().atMost( 20, TimeUnit.SECONDS )
            .with()
            .pollInterval( 250, TimeUnit.MILLISECONDS )
            .pollDelay( 500, TimeUnit.MILLISECONDS )
            .until( () -> driver.findElement( By.id( "HOOK_PAYMENT" ) ).isDisplayed() );

    driver.findElement( By.id( "HOOK_PAYMENT" ) ).findElement( By.className( "bankwire" ) ).click();

    await().atMost( 20, TimeUnit.SECONDS )
            .with()
            .pollInterval( 250, TimeUnit.MILLISECONDS )
            .pollDelay( 500, TimeUnit.MILLISECONDS )
            .until( () -> driver.findElement( By.className( "cart_navigation" ) ).findElements( By.className( "button" ) ).get( 1 ).isDisplayed() );
    driver.findElement( By.className( "cart_navigation" ) ).findElements( By.className( "button" ) ).get( 1 ).click();
  }
}
