package seleniumTesting.clothesSite.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class MyAccountPage {
  WebDriver driver;

  public MyAccountPage( WebDriver driver ) {
    this.driver = driver;
  }

  public void navigateToMyPersonalDetailsPage(){
    await().atMost( 20, TimeUnit.SECONDS )
            .with()
            .pollInterval( 250, TimeUnit.MILLISECONDS )
            .pollDelay( 500, TimeUnit.MILLISECONDS )
            .until( () -> driver.findElement( By.className( "myaccount-link-list" ) ).isDisplayed() );


    driver.findElement( By.className( "myaccount-link-list" ) ).findElements( By.tagName( "li" ) ).get( 3 ).click();
  }

  public void changePasswordAndSubmit(){
    await().atMost( 20, TimeUnit.SECONDS )
            .with()
            .pollInterval( 250, TimeUnit.MILLISECONDS )
            .pollDelay( 500, TimeUnit.MILLISECONDS )
            .until( () -> driver.findElement( By.id( "old_passwd" ) ).isDisplayed() );

    driver.findElement( By.id( "old_passwd" ) ).sendKeys( "SuperSafe2" );
    driver.findElement( By.id( "passwd" ) ).sendKeys( "SuperSafe3" );
    driver.findElement( By.id( "confirmation" ) ).sendKeys( "SuperSafe3" );

    driver.findElement( By.cssSelector( "button.btn:nth-child(1)" ) ).click();
  }
}
