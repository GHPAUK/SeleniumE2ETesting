package seleniumTesting.phpTravels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.time.Duration;
import java.util.List;
import static org.awaitility.Awaitility.await;

public class PHPTravelsFlights {

  private final WebDriver driver;

  public PHPTravelsFlights(WebDriver driver) { this.driver = driver; }

  public void homepageToBookingFlight() {
    navigateToWebpage();
    acceptCookies();
    changeCurrency();
    checkOnFlightsTab();
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

  private void acceptCookies() {
    driver.findElement(By.id("cookie_stop") ).click();
  }

  private void checkOnFlightsTab() {
    WebElement flightsTab = driver.findElement(By.cssSelector("#fadein > header > div." +
            "header-menu-wrapper.padding-right-100px.padding-left-100px > div > div >" +
            "div > div > div.main-menu-content > nav > ul > li:nth-child(3)") );
    if (!flightsTab.isSelected() ) { flightsTab.click(); }

  }

  private void changeCurrency() {
    driver.findElement( By.id( "currency" ) ).click();
    List<WebElement> currencies = driver.findElements( By.cssSelector( "a.dropdown-item" ) );
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
    driver.findElement( By.id("departure") ).clear();
    driver.findElement( By.id("departure") ).click();
    driver.findElement(By.cssSelector("i.mdi-long-arrow-right") ).click();
    driver.findElement(By.cssSelector("i.mdi-long-arrow-right") ).click();
    driver.findElement(By.cssSelector("i.mdi-long-arrow-right") ).click();
    driver.findElements( By.cssSelector("td.day") ).get(14).click();
  }

  private void changeLeaveByDate() {
    driver.findElement( By.id("return") ).clear();
    driver.findElement( By.id("return") ).click();
    driver.findElements( By.cssSelector("td.day ") ).get(63).click();
  }

  private void changeNumberOfPassengers() {
    driver.findElement( By.cssSelector( "div.dropdown-contain:nth-child(1) > a:nth-child(1)" ) ).click();
    await().atMost(Duration.ofSeconds(20) ).until(
            () -> driver.findElement(By.cssSelector("#onereturn > div.col-lg-1.pr-0 > div > div > div > div") ).isDisplayed() );
    driver.findElement( By.className("qtyInc") ).findElement(By.tagName("i") ).click();
  }

  private void searchFlights() {
    driver.findElement( By.id( "flights-search" ) ).click();
  }

  private void switchToRoundTrip() {
    driver.findElement( By.id( "round-trip" ) ).click();
  }

}
