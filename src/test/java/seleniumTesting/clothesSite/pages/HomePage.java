package seleniumTesting.clothesSite.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class HomePage {
  WebDriver driver;

  public HomePage( WebDriver driver ) {
    this.driver = driver;
  }

  public void navigateToSiteHomePage( String uri ) {
    driver.navigate().to( uri );
    await().atMost( 10, TimeUnit.SECONDS )
            .with()
            .pollInterval( 50, TimeUnit.MILLISECONDS )
            .pollDelay( 1, TimeUnit.SECONDS )
            .until( () -> driver.findElement( By.id( "block_top_menu" ) ).isDisplayed() );
//    WebDriverWait wait = new WebDriverWait( driver, Duration.ofSeconds( 10 ) );
//    wait.until( ExpectedConditions.visibilityOfElementLocated( By.id( "block_top_menu" ) ) );
  }

  public void navigateToDressesCategoriesPage(){

    await().atMost( 15, TimeUnit.SECONDS )
            .with()
            .pollInterval( 50, TimeUnit.MILLISECONDS )
            .pollDelay( 2, TimeUnit.SECONDS )
            .until( () -> driver.findElement( By.id( "block_top_menu" ) )
                    .findElement( By.className( "menu-content" ) )
                    .findElement( By.cssSelector( ".sf-menu > li:nth-child(2) > a:nth-child(1)" ) )
                    .isDisplayed());

    driver.findElement( By.id( "block_top_menu" ) )
            .findElement( By.className( "menu-content" ) )
            .findElement( By.cssSelector( ".sf-menu > li:nth-child(2) > a:nth-child(1)" ) ).click();
  }
}
