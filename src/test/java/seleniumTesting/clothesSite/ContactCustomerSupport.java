package seleniumTesting.clothesSite;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import seleniumTesting.clothesSite.pages.HomePage;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class ContactCustomerSupport {
  WebDriver driver;

  @BeforeAll
  static void setupClass() {
    WebDriverManager.firefoxdriver().setup();
  }

  @BeforeEach
  void setupTest() {
    driver = new FirefoxDriver();
  }

  @AfterEach
  void teardown() {
    if ( driver != null ) {
    }
  }

  @Test
  public void NavigateToSiteAndContactToFillTheForm() throws InterruptedException {

    HomePage homePage = new HomePage( driver );
    homePage.navigateToSiteHomePage( "http://automationpractice.com/index.php" );

    await().atMost( 25, TimeUnit.SECONDS )
            .with()
            .pollInterval( 500, TimeUnit.MILLISECONDS )
            .pollDelay( 1, TimeUnit.SECONDS )
            .until( () -> driver.findElement( By.id( "contact-link" ) ).isDisplayed() );

//    driver.navigate().to( "http://automationpractice.com/index.php" );
//    //Thread.sleep( 5000 );
 driver.findElement( By.id( "contact-link" ) ).click();
    driver.findElement( By.id( "id_contact" ) ).click();
    driver.findElement( By.id( "id_contact" ) ).findElements( By.tagName( "option" ) ).get( 1 ).click();
    driver.findElement( By.cssSelector( "#email" ) ).sendKeys( "testingTesting123@test.com" );
    driver.findElement( By.cssSelector( "#id_order" ) ).sendKeys( "reference" );
    driver.findElement( By.id( "message" ) ).sendKeys( "Hello" );
    driver.findElement( By.cssSelector( "#fileUpload" ) ).getCssValue( ".filename" );
    driver.findElement( By.id( "submitMessage" ) ).click();


  }

}
