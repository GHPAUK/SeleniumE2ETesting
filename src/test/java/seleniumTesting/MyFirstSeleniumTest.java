package seleniumTesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class MyFirstSeleniumTest {
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
      driver.quit();
    }
  }

  @Test
  void test() {
    googleSearchFor("Palindrome");
    assertThat( driver.getPageSource() ).info.toString().contains( "Palindrome" );
  }

  private void googleSearchFor(String search) {
    driver.navigate().to( "http://www.google.com" );
    driver.findElement( By.id( "L2AGLb" ) ).click();
    driver.findElement( By.className( "gLFyf" ) ).sendKeys( search );
    driver.findElement( By.className( "gLFyf" ) ).submit();
  }
}
