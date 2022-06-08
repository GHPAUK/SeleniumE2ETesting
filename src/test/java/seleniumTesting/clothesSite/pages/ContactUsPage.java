package seleniumTesting.clothesSite.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage {
  WebDriver driver;

  public ContactUsPage( WebDriver driver ) {
    this.driver = driver;
  }

  public void fillOutContactUsPageFormAndSubmit(){
    driver.findElement( By.id( "id_contact" ) ).findElements( By.tagName( "option" ) ).get( 1 ).click();
    driver.findElement( By.cssSelector( "#email" ) ).sendKeys( "testingTesting123@test.com" );
    driver.findElement( By.cssSelector( "#id_order" ) ).sendKeys( "reference" );
    driver.findElement( By.id( "message" ) ).sendKeys( "Hello" );
    driver.findElement( By.cssSelector( "#fileUpload" ) ).getCssValue( ".filename" );
    driver.findElement( By.id( "submitMessage" ) ).click();
  }
}
