package seleniumTesting.phpTravels;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@Disabled
public class PhpTravelsTest {
  WebDriver driver;

  @BeforeAll
  static void setupClass() {
    WebDriverManager.chromedriver().setup();
  }

  @BeforeEach
  void setupTest() {
    driver = new ChromeDriver();
  }

  @AfterEach
  void teardown() {
    if ( driver != null ) {
//      driver.quit();
    }
  }

  @Test
  void flightsTest() {
    PHPTravelsFlights flights = new PHPTravelsFlights(driver);

    flights.homepageToBookingFlight();
  }

}
