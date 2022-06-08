package seleniumTesting.clothesSite.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class DressesCategoryPage {
  WebDriver driver;

  public DressesCategoryPage( WebDriver driver ) {
    this.driver = driver;
  }

  public void navigateToSummerDressesProductsPage(){
    await().atMost( 20, TimeUnit.SECONDS )
            .with()
            .pollInterval( 500, TimeUnit.MILLISECONDS )
            .pollDelay( 1, TimeUnit.SECONDS )
            .until( () -> driver.findElement( By.id( "subcategories" ) )
                    .findElement( By.className( "subcategory-image" ) ).isDisplayed());

    driver.findElement( By.id( "subcategories" ) )
            .findElements( By.className( "subcategory-image" ) ).get( 2 ).click();
  }
}
