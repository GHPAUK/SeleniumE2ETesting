package seleniumTesting.clothesSite.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class AuthenticationPage {
  WebDriver driver;

  public AuthenticationPage( WebDriver driver ) {
    this.driver = driver;
  }

  public void signInPageFillDetailsAndLogIn(){
    await().atMost( 20, TimeUnit.SECONDS )
            .with()
            .pollInterval( 250, TimeUnit.MILLISECONDS )
            .pollDelay( 500, TimeUnit.MILLISECONDS )
            .until( () -> driver.findElement( By.id( "email" ) ).isDisplayed() );

    driver.findElement( By.id( "email" ) ).sendKeys( "testingTesting123@test.com" );

    driver.findElement( By.id( "passwd" ) ).sendKeys( "SuperSafe1" );

    driver.findElement( By.id( "SubmitLogin" ) ).click();
  }
}
