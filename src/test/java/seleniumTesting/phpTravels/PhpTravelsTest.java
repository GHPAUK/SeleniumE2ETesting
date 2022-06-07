package seleniumTesting.phpTravels;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class PhpTravelsTest {
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
//      driver.quit();
    }
  }

  @Test
  public void runDriver() {
    navigateToWebpage();
    changeCurrency();
    switchToRoundTrip();
    inputFlyingFromAirport( "Tokyo intl" );
    inputFlyingToAirport( "Luton" );
    changeDepartureDate();
    changeLeaveByDate();
    changeNumberOfPassengers();
    searchFlights();
  }

  private void navigateToWebpage() {
    driver.navigate().to( "https://www.phptravels.net/" );
  }

  private void changeCurrency() {
    driver.findElement( By.id( "currency" ) ).click();
    List< WebElement > currencies = driver.findElements( By.cssSelector( "a.dropdown-item" ) );
    currencies.get( 13 ).click();
  }

  private void inputFlyingFromAirport( String fromAirport ) {
    driver.findElement( By.id( "autocomplete" ) ).sendKeys( fromAirport );
    List< WebElement > airportResults = driver.findElements( By.cssSelector( "div.autocomplete-result" ) );
    airportResults.get( 0 ).click();
  }

  private void inputFlyingToAirport( String fromAirport ) {
    driver.findElement( By.id( "autocomplete2" ) ).sendKeys( fromAirport );
    List< WebElement > airportResults = driver.findElements( By.cssSelector( "div.autocomplete-result" ) );
    airportResults.get( 0 ).click();
  }

  private void changeDepartureDate() {
    driver.findElement( By.id( "departure" ) ).click();
    driver.findElement( By.id( "departure" ) ).clear();
    driver.findElement( By.cssSelector( "div.datepicker:nth-child(32) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(4) > td:nth-child(5)" ) ).click();
  }

  private void changeLeaveByDate() {
    driver.findElement( By.id( "return" ) ).click();
    driver.findElement( By.id( "return" ) ).clear();
    driver.findElement( By.id( "return" ) ).sendKeys( "26-07-2022" );
  }

  private void changeNumberOfPassengers() {
    driver.findElement( By.cssSelector( "div.dropdown-contain:nth-child(1) > a:nth-child(1)" ) ).click();
    driver.findElement( By.cssSelector( ".adult_qty > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > i:nth-child(1)" ) ).click();
  }

  private void searchFlights() {
    driver.findElement( By.id( "flights-search" ) ).click();
  }

  private void switchToRoundTrip() {
    driver.findElement( By.id( "round-trip" ) ).click();
  }
}
