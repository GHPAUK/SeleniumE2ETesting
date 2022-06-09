package seleniumTesting.clothesSite.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class ShoppingCartSummaryPage {
  WebDriver driver;

  public ShoppingCartSummaryPage( WebDriver driver ) {
    this.driver = driver;
  }

  public void summaryProceedToCheckoutBtn() {
    await().atMost( 20, TimeUnit.SECONDS )
            .with()
            .pollInterval( 250, TimeUnit.MILLISECONDS )
            .pollDelay( 500, TimeUnit.MILLISECONDS )
            .until( () -> driver.findElement( By.className( "cart_navigation" ) )
                    .findElement( By.className( "button" ) ).isDisplayed() );

    driver.findElement( By.className( "cart_navigation" ) )
            .findElement( By.className( "button" ) ).click();
  }

  public void addressProceedToCheckout() {
    await().atMost( 20, TimeUnit.SECONDS )
            .with()
            .pollInterval( 250, TimeUnit.MILLISECONDS )
            .pollDelay( 500, TimeUnit.MILLISECONDS )
            .until( () -> driver.findElement( By.className( "cart_navigation" ) ).findElement( By.className( "button" ) ).isDisplayed() );

    driver.findElement( By.className( "cart_navigation" ) ).findElement( By.className( "button" ) ).click();
  }

  public void shippingAcceptToSAndProceedToCheckout() {
    WebDriverWait wait = new WebDriverWait( driver, Duration.ofSeconds( 10 ) );
    wait.until( ExpectedConditions.elementToBeClickable( driver.findElement( By.className( "cart_navigation" ) ).findElement( By.className( "button" ) ) ) );
    driver.findElement( By.id( "cgv" ) ).click();
    driver.findElement( By.className( "cart_navigation" ) ).findElement( By.className( "button" ) ).click();  }

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
            .until( () -> driver.findElement( By.className( "cart_navigation" ) ).findElement( By.className( "button" ) ).isDisplayed() );
    driver.findElement( By.className( "cart_navigation" ) ).findElement( By.className( "button" ) ).click();  }
}
