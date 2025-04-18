// Generated by Selenium IDE
package edu.pitt.cs;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class D3Test {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--headless");
    driver = new ChromeDriver(options);
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void tEST1LINKS() {
    driver.get("https://cs1632.appspot.com/");
    driver.findElement(By.linkText("Reset")).click();
    driver.findElement(By.linkText("Reset")).click();
    vars.put("Resetlink", driver.findElement(By.xpath("//a[contains(@href, \'/reset\')]")).getText());
    assertEquals(vars.get("Resetlink").toString(), "Reset");
  }
  @Test
  public void tEST2RESET() {
    driver.get("https://cs1632.appspot.com/");
    js.executeScript("document.cookie = \"1=true\";document.cookie = \"2=true\";document.cookie = \"3=true\";");
    driver.findElement(By.linkText("Reset")).click();
    assertThat(driver.findElement(By.id("cat-id1")).getText(), is("ID 1. Jennyanydots"));
    assertThat(driver.findElement(By.id("cat-id2")).getText(), is("ID 2. Old Deuteronomy"));
    assertThat(driver.findElement(By.id("cat-id3")).getText(), is("ID 3. Mistoffelees"));
  }
  @Test
  public void tEST3CATALOG() {
    driver.get("https://cs1632.appspot.com/");
    driver.manage().window().setSize(new Dimension(874, 832));
    driver.findElement(By.xpath("//a[contains(text(),\'Catalog\')]")).click();
    {
      WebElement element = driver.findElement(By.xpath("//li[2]/img"));
      String attribute = element.getAttribute("src");
      String full = "https://cs1632.appspot.com" + attribute;
      vars.put("secondimage", attribute);
    }
    assertEquals(vars.get("secondimage").toString(), "https://cs1632.appspot.com/images/cat2.jpg");
  }
  @Test
  public void tEST4LISTING() {
    driver.get("https://cs1632.appspot.com");
    driver.findElement(By.linkText("Catalog")).click();
    vars.put("count", driver.findElements(By.xpath("//div[@id=\'listing\']/ul/li")).size());
    assertEquals(vars.get("count").toString(), "3");
    driver.findElement(By.id("cat-id1")).click();
    driver.findElement(By.id("cat-id2")).click();
    driver.findElement(By.id("cat-id3")).click();
    vars.put("number3", driver.findElement(By.xpath("(//ul[@class=\'list-group\']/li)[3]")).getText());
    assertEquals(vars.get("number3").toString(), "ID 3. Mistoffelees");
    assertThat(driver.findElement(By.id("cat-id3")).getText(), is("ID 3. Mistoffelees"));
  }


  @Test
  public void tEST5RENTACAT() {
    driver.get("https://cs1632.appspot.com/");
    driver.manage().window().setSize(new Dimension(1470, 832));
    driver.findElement(By.linkText("Rent-A-Cat")).click();
    {
      List<WebElement> elements = driver.findElements(By.cssSelector(".form-group:nth-child(3) .btn"));
      assert(elements.size() > 0);
    }
    {
      List<WebElement> elements = driver.findElements(By.cssSelector(".form-group:nth-child(4) .btn"));
      assert(elements.size() > 0);
    }
  }
  @Test
  public void tEST6RENT() {
    driver.get("https://cs1632.appspot.com");
    driver.findElement(By.linkText("Rent-A-Cat")).click();
    driver.findElement(By.id("rentID")).click();
    driver.findElement(By.id("rentID")).sendKeys("1");
    driver.findElement(By.cssSelector(".form-group:nth-child(3) .btn")).click();
    vars.put("id1", driver.findElement(By.xpath("//div[@id=\'listing\']/ul/li")).getText());
    assertEquals(vars.get("id1").toString(), "Rented out");
    vars.put("id2", driver.findElement(By.xpath("//div[@id=\'listing\']/ul/li[2]")).getText());
    assertEquals(vars.get("id2").toString(), "ID 2. Old Deuteronomy");
    vars.put("id3", driver.findElement(By.xpath("//div[@id=\'listing\']/ul/li[3]")).getText());
    assertEquals(vars.get("id3").toString(), "ID 3. Mistoffelees");
    assertThat(driver.findElement(By.id("rentResult")).getText(), is("Success!"));
  }
  @Test
  public void tEST7RETURN() {
    driver.get("https://cs1632.appspot.com/");
    js.executeScript("document.cookie = \"1=false\";document.cookie = \"2=true\";document.cookie = \"3=false\";");
    driver.findElement(By.id("cat-id1")).click();
    driver.findElement(By.linkText("Rent-A-Cat")).click();
    assertThat(driver.findElement(By.id("cat-id1")).getText(), is("ID 1. Jennyanydots"));
    driver.findElement(By.id("cat-id2")).click();
    assertThat(driver.findElement(By.id("cat-id2")).getText(), is("Rented out"));
    driver.findElement(By.id("cat-id3")).click();
    assertThat(driver.findElement(By.id("cat-id3")).getText(), is("ID 3. Mistoffelees"));
    driver.findElement(By.id("returnID")).click();
    driver.findElement(By.id("returnID")).sendKeys("2");
    driver.findElement(By.id("returnID")).sendKeys(Keys.ENTER);
    driver.findElement(By.cssSelector(".form-group:nth-child(4) .btn")).click();
    assertThat(driver.findElement(By.id("returnResult")).getText(), is("Success!"));
  }
  @Test
  public void tEST8FEEDACAT() {
    driver.get("https://cs1632.appspot.com/");
    driver.manage().window().setSize(new Dimension(874, 832));
    driver.findElement(By.linkText("Feed-A-Cat")).click();
    {
      List<WebElement> elements = driver.findElements(By.cssSelector(".btn"));
      assert(elements.size() > 0);
    }
  }
  @Test
  public void tEST9FEED() {
    driver.get("https://cs1632.appspot.com/");
    driver.findElement(By.linkText("Feed-A-Cat")).click();
    driver.findElement(By.id("catnips")).click();
    driver.findElement(By.id("catnips")).sendKeys("6");
    driver.findElement(By.cssSelector(".btn")).click();
    {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("feedResult")));
    }
    assertThat(driver.findElement(By.xpath("//*[contains(text(),\'Nom, nom, nom.\')]")).getText(), is("Nom, nom, nom."));
  }
  @Test
  public void tEST10GREETACAT() {
    driver.get("https://cs1632.appspot.com/");
    driver.findElement(By.linkText("Greet-A-Cat")).click();
    driver.findElement(By.cssSelector("#greeting > h4")).click();
    assertThat(driver.findElement(By.cssSelector("#greeting > h4")).getText(), is("Meow!Meow!Meow!"));
  }
  @Test
  public void tEST11GREETACATWITHNAME() {
    driver.get("https://cs1632.appspot.com//greet-a-cat/Jennyanydots");
    driver.manage().window().setSize(new Dimension(874, 832));
    driver.findElement(By.cssSelector("#greeting > h4")).click();
    driver.findElement(By.cssSelector("#greeting > h4")).click();
    {
      WebElement element = driver.findElement(By.cssSelector("#greeting > h4"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    {
      List<WebElement> elements = driver.findElements(By.cssSelector("#greeting > h4"));
      assert(elements.size() > 0);
    }
    assertThat(driver.findElement(By.cssSelector("#greeting > h4")).getText(), is("Meow! from Jennyanydots."));
  }
    @Test
  public void dEFECT1FUNLINKS() {
    driver.get("https://cs1632.appspot.com");
    driver.findElement(By.linkText("Catalog")).click();
    vars.put("https://cs1632.appspot.com", driver.getWindowHandle());
    assertEquals(vars.get("linkurl").toString(), "https://cs1632.appspot.com/");
  }
  @Test
  public void dEFECT2FUNGREETACAT() {
    driver.get("https://cs1632.appspot.com/");
    driver.manage().window().setSize(new Dimension(988, 832));
    driver.findElement(By.linkText("Rent-A-Cat")).click();
    driver.findElement(By.id("rentID")).click();
    driver.findElement(By.id("rentID")).sendKeys("1");
    driver.findElement(By.cssSelector(".form-group:nth-child(3) .btn")).click();
    driver.findElement(By.linkText("Greet-A-Cat")).click();
    assertThat(driver.findElement(By.cssSelector("#greeting > h4")).getText(), is("Meow!Meow!"));
  }
  @Test
  public void dEFECT3FUNGREETACATWITHNAME() {
    driver.get("https://cs1632.appspot.com");
    driver.findElement(By.linkText("Rent-A-Cat")).click();
    driver.findElement(By.id("rentID")).click();
    driver.findElement(By.id("rentID")).sendKeys("1");
    driver.findElement(By.cssSelector(".form-group:nth-child(3) .btn")).click();
    driver.get("https://cs1632.appspot.com/greet-a-cat/Jennyanydots");
    driver.findElement(By.cssSelector("#greeting > h4")).click();
    assertThat(driver.findElement(By.cssSelector("#greeting > h4")).getText(), is("Jennyanydots is not here"));
  }

}

