package seleniumTesting.clothesSite;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ClothesSiteTest {
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
  void navigateToCasualDressesAndAddOneToBasketCreateAnAccount() throws InterruptedException {

    driver.navigate().to( "http://automationpractice.com/index.php" );
    Thread.sleep( 10000 );
    WebElement topBlockMenu = driver.findElement( By.id( "block_top_menu" ) );
    WebElement menu = topBlockMenu.findElement( By.className( "menu-content" ) );
    WebElement dresses = menu.findElement( By.cssSelector( ".sf-menu > li:nth-child(2) > a:nth-child(1)" ) );
    dresses.click();
    Thread.sleep( 7000 );
    driver.findElement( By.cssSelector( "#subcategories > ul:nth-child(2) > li:nth-child(3) > div:nth-child(1) > a:nth-child(1) > img:nth-child(1)" ) ).click();
    Thread.sleep( 7000 );
    driver.findElement( By.cssSelector( "li.ajax_block_product:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > img:nth-child(1)" ) ).click();
    Thread.sleep( 7000 );
    driver.findElement( By.cssSelector( "#thumbnail_16 > a:nth-child(1)" ) ).click();
    Thread.sleep( 2000 );
    driver.findElement( By.cssSelector( ".fancybox-item" ) ).click();
    Thread.sleep( 2000 );
    driver.findElement( By.cssSelector( "#thumbnail_17 > a:nth-child(1)" ) ).click();
    Thread.sleep( 2000 );
    driver.findElement( By.cssSelector( ".fancybox-item" ) ).click();
    Thread.sleep( 2000 );
    driver.findElement( By.cssSelector( "#thumbnail_18 > a:nth-child(1)" ) ).click();
    Thread.sleep( 2000 );
    driver.findElement( By.cssSelector( ".fancybox-item" ) ).click();
    Thread.sleep( 2000 );
    driver.findElement( By.id( "group_1" ) ).click();
    Thread.sleep( 2000 );
    driver.findElement( By.cssSelector( "#group_1 > option:nth-child(2)" ) ).click();
    Thread.sleep( 2000 );
    driver.findElement( By.id( "color_8" ) ).click();
    Thread.sleep( 2000 );
    driver.findElement( By.id( "add_to_cart" ) ).click();
    Thread.sleep( 10000 );
    driver.findElement( By.cssSelector( "a.btn:nth-child(2)" ) ).click();
    Thread.sleep( 5000 );
    driver.findElement( By.cssSelector( ".standard-checkout" ) ).click();
    Thread.sleep( 10000 );
    driver.findElement( By.id( "email_create" ) ).sendKeys( "testingTesting12345@test.com" );
    Thread.sleep( 1000 );
    driver.findElement( By.id( "SubmitCreate" ) ).click();
    Thread.sleep( 10000 );
    driver.findElement( By.id( "id_gender1" ) ).click();
    Thread.sleep( 500 );
    driver.findElement( By.id( "customer_firstname" ) ).sendKeys( "John" );
    Thread.sleep( 500 );
    driver.findElement( By.id( "customer_lastname" ) ).sendKeys( "Thomas" );
    Thread.sleep( 500 );
    driver.findElement( By.id( "passwd" ) ).sendKeys( "SuperSafe1" );
    Thread.sleep( 500 );
    driver.findElement( By.id( "days" ) ).click();
    Thread.sleep( 200 );
    driver.findElement( By.cssSelector( "#days > option:nth-child(8)" ) ).click();
    Thread.sleep( 500 );
    driver.findElement( By.id( "months" ) ).click();
    Thread.sleep( 200 );
    driver.findElement( By.cssSelector( "#months > option:nth-child(5)" ) ).click();
    Thread.sleep( 500 );
    driver.findElement( By.id( "years" ) ).click();
    Thread.sleep( 200 );
    driver.findElement( By.cssSelector( "#years > option:nth-child(34)" ) ).click();
    Thread.sleep( 500 );
    driver.findElement( By.id( "uniform-newsletter" ) ).click();
    Thread.sleep( 500 );
    driver.findElement( By.id( "uniform-optin" ) ).click();
    Thread.sleep( 500 );

    driver.findElement( By.id( "address1" ) ).sendKeys( "34 GreenPastures, Solly" );
    Thread.sleep( 500 );
    driver.findElement( By.id( "city" ) ).sendKeys( "Mantester" );
    Thread.sleep( 500 );
    driver.findElement( By.id( "id_state" ) ).click();
    Thread.sleep( 600 );
    driver.findElement( By.cssSelector( "#id_state > option:nth-child(3)" ) ).click();
    Thread.sleep( 600 );
    driver.findElement( By.id( "postcode" ) ).sendKeys( "00000" );
    Thread.sleep( 500 );
    driver.findElement( By.id( "phone_mobile" ) ).sendKeys( "07654245721" );
    Thread.sleep( 500 );
    driver.findElement( By.id( "submitAccount" ) ).click();
    Thread.sleep( 10000 );
    driver.findElement( By.cssSelector( "button.button:nth-child(4)" ) ).click();
    Thread.sleep( 10000 );
    driver.findElement( By.id( "cgv" ) ).click();
    Thread.sleep( 1000 );
    driver.findElement( By.cssSelector( "button.button:nth-child(4)" ) ).click();
    Thread.sleep( 10000 );
    WebElement hookPayment = driver.findElement( By.id( "HOOK_PAYMENT" ) );
    WebElement bank = hookPayment.findElement( By.className( "bankwire" ) );
    Thread.sleep( 1000 );
    bank.click();
    Thread.sleep( 10000 );
    driver.findElement( By.cssSelector( "button.button-medium" ) ).click();
  }

  @Test
  void navigateToCasualDressesAndAddOneToBasketSignIn() throws InterruptedException {

    driver.navigate().to( "http://automationpractice.com/index.php" );
    Thread.sleep( 10000 );
    WebElement topBlockMenu = driver.findElement( By.id( "block_top_menu" ) );
    WebElement menu = topBlockMenu.findElement( By.className( "menu-content" ) );
    WebElement dresses = menu.findElement( By.cssSelector( ".sf-menu > li:nth-child(2) > a:nth-child(1)" ) );
    dresses.click();
    Thread.sleep( 7000 );
    driver.findElement( By.cssSelector( "#subcategories > ul:nth-child(2) > li:nth-child(3) > div:nth-child(1) > a:nth-child(1) > img:nth-child(1)" ) ).click();
    Thread.sleep( 7000 );
    driver.findElement( By.cssSelector( "li.ajax_block_product:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > img:nth-child(1)" ) ).click();
    Thread.sleep( 7000 );
    driver.findElement( By.cssSelector( "#thumbnail_16 > a:nth-child(1)" ) ).click();
    Thread.sleep( 2000 );
    driver.findElement( By.cssSelector( ".fancybox-item" ) ).click();
    Thread.sleep( 2000 );
    driver.findElement( By.cssSelector( "#thumbnail_17 > a:nth-child(1)" ) ).click();
    Thread.sleep( 2000 );
    driver.findElement( By.cssSelector( ".fancybox-item" ) ).click();
    Thread.sleep( 2000 );
    driver.findElement( By.cssSelector( "#thumbnail_18 > a:nth-child(1)" ) ).click();
    Thread.sleep( 2000 );
    driver.findElement( By.cssSelector( ".fancybox-item" ) ).click();
    Thread.sleep( 2000 );
    driver.findElement( By.id( "group_1" ) ).click();
    Thread.sleep( 2000 );
    driver.findElement( By.cssSelector( "#group_1 > option:nth-child(2)" ) ).click();
    Thread.sleep( 2000 );
    driver.findElement( By.id( "color_8" ) ).click();
    Thread.sleep( 2000 );
    driver.findElement( By.id( "add_to_cart" ) ).click();
    Thread.sleep( 10000 );
    driver.findElement( By.cssSelector( "a.btn:nth-child(2)" ) ).click();
    Thread.sleep( 5000 );
    driver.findElement( By.cssSelector( ".standard-checkout" ) ).click();
    Thread.sleep( 10000 );
    driver.findElement( By.id( "email" ) ).sendKeys( "testingTesting123@test.com" );
    Thread.sleep( 1000 );
    driver.findElement( By.id( "passwd" ) ).sendKeys( "SuperSafe1" );
    Thread.sleep( 1000 );
    driver.findElement( By.id( "SubmitLogin" ) ).click();
    Thread.sleep( 10000 );
    driver.findElement( By.cssSelector( "button.button:nth-child(4)" ) ).click();
    Thread.sleep( 10000 );
    driver.findElement( By.id( "cgv" ) ).click();
    Thread.sleep( 1000 );
    driver.findElement( By.cssSelector( "button.button:nth-child(4)" ) ).click();
    Thread.sleep( 10000 );
    WebElement hookPayment = driver.findElement( By.id( "HOOK_PAYMENT" ) );
    WebElement bank = hookPayment.findElement( By.className( "bankwire" ) );
    Thread.sleep( 1000 );
    bank.click();
    Thread.sleep( 10000 );
    driver.findElement( By.cssSelector( "button.button-medium" ) ).click();
  }

  //  List<WebElement> dresses = driver.findElements( By.className( "product-container" ) );
//  Actions actions = new Actions( driver );
//  actions.moveToElement( dresses.get(0) ).perform();
//  List< WebElement > addToCartButton =  driver.findElements( By.className( "ajax_add_to_cart_button") );
//  addToCartButton.get( 0 ).click();
}
