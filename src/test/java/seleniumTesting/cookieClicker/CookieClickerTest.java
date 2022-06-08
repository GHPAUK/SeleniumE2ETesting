package seleniumTesting.cookieClicker;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CookieClickerTest {
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
  public void getCookies() throws InterruptedException {
    driver.navigate().to( "https://orteil.dashnet.org/cookieclicker/" );
    Thread.sleep( 10000 );
    driver.findElement( By.id( "langSelect-EN" ) ).click();
    Thread.sleep( 5000 );

    for (int i = 0; i < 100000; i++){
      driver.findElement( By.id( "bigCookie" ) ).click();
      driver.findElement( By.id( "bigCookie" ) ).click();
      driver.findElement( By.id( "bigCookie" ) ).click();
      driver.findElement( By.id( "bigCookie" ) ).click();
      driver.findElement( By.id( "bigCookie" ) ).click();
    }
  }
}
