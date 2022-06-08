package seleniumTesting.clothesSite.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class SummerDressesProductsPage {
  WebDriver driver;

  // Product Listing Page Elements
  WebElement quantityIncreaseBtn;
  WebElement quantityDecreaseBtn;
  List< WebElement > dressSizeOptions;
  List< WebElement > colourOptions;
  private List< WebElement > thumbnails;

  public SummerDressesProductsPage( WebDriver driver ) {
    this.driver = driver;
  }

  public void pressProductCard( int index ) {
    await().atMost( 20, TimeUnit.SECONDS )
            .with()
            .pollInterval( 250, TimeUnit.MILLISECONDS )
            .pollDelay( 500, TimeUnit.MILLISECONDS )
            .until( () ->  driver.findElement( By.className( "product_list" ) ).findElements( By.className( "product-container" ) ).get( index ).isDisplayed() );

    driver.findElement( By.className( "product_list" ) ).findElements( By.className( "product-container" ) ).get( index ).click();

  }

  public void addProductToCartAndProceedToCheckout() {
    driver.findElement( By.id( "add_to_cart" ) ).click();

    await().atMost( 10, TimeUnit.SECONDS )
            .with()
            .pollInterval( 25, TimeUnit.MILLISECONDS )
            .pollDelay( 500, TimeUnit.MILLISECONDS )
            .until( () -> driver.findElement( By.id( "layer_cart" ) ).findElement( By.className( "button-container" ) ).isDisplayed() );

    driver.findElement( By.id( "layer_cart" ) ).findElements( By.className( "button" ) ).get( 1 ).click();
  }

  public void changeDressColour( int colour ) {
    this.colourOptions = driver.findElement( By.id( "color_to_pick_list" ) ).findElements( By.className( "color_pick" ) );
    colourOptions.get( colour ).click();
  }

  public void changeDressSize( int size ) {
    this.dressSizeOptions = driver.findElement( By.id( "group_1" ) ).findElements( By.tagName( "option" ) );
    dressSizeOptions.get( size ).click();
  }

  public void increaseProductQuantity( int increaseBy ) {
    for ( int i = 0; i < increaseBy; i++ ) {
      this.quantityIncreaseBtn = driver.findElement( By.id( "quantity_wanted_p" ) ).findElement( By.className( "product_quantity_up" ) );
      quantityIncreaseBtn.click();
    }
  }

  public void decreaseProductQuantity( int decreaseBy ) {
    for ( int i = 0; i < decreaseBy; i++ ) {
      this.quantityDecreaseBtn = driver.findElement( By.id( "quantity_wanted_p" ) ).findElement( By.className( "product_quantity_down" ) );
      quantityDecreaseBtn.click();
    }
  }

  public List< WebElement > getThumbnails() {
    await().atMost( 20, TimeUnit.SECONDS )
            .with()
            .pollInterval( 500, TimeUnit.MILLISECONDS )
            .pollDelay( 1, TimeUnit.SECONDS )
            .until( () -> driver.findElement( By.id( "thumbs_list_frame" ) ).findElement( By.className( "fancybox" ) ).isDisplayed() );

    this.thumbnails = driver.findElement( By.id( "thumbs_list_frame" ) ).findElements( By.className( "fancybox" ) );
    return thumbnails;
  }

  public void viewThumbnails() {
    await().atMost( 20, TimeUnit.SECONDS )
            .with()
            .pollInterval( 1, TimeUnit.SECONDS )
            .pollDelay( 0, TimeUnit.SECONDS )
            .until( () -> driver.findElement( By.id( "thumbs_list_frame" ) ).findElement( By.className( "fancybox" ) ).isDisplayed() );

    for ( int i = 0; i < getThumbnails().size(); i++ ) {
      driver.findElement( By.id( "thumbs_list_frame" ) ).findElements( By.className( "fancybox" ) ).get( i ).click();
      await().atMost( 10, TimeUnit.SECONDS )
              .with()
              .pollInterval( 50, TimeUnit.MILLISECONDS )
              .pollDelay( 1, TimeUnit.SECONDS )
              .until( () -> driver.findElement( By.className( "fancybox-close" ) ).isDisplayed() );

      driver.findElement( By.className( "fancybox-close" ) ).click();

      WebDriverWait wait = new WebDriverWait( driver, Duration.ofSeconds( 10 ) );
      wait.until( ExpectedConditions.visibilityOfElementLocated( By.tagName( thumbnails.get( 0 ).getTagName() ) ) );
    }
  }
}
