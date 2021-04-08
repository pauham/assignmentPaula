package stepDefinitions;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
	WebDriver driver;
	String emailString;
	
	@Given("I have navigated at Mailchimp")
	public void i_have_navigated_at_mailchimp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\paula\\eclipse\\java-2020-09\\eclipse\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://login.mailchimp.com/signup/");
		driver.manage().window().maximize();
	}

	@Given("I have entered email")
	public void i_have_entered() {
		Random rand = new Random();
		int randomInt = rand.nextInt(1000000);
		emailString = "svenne" + randomInt + "@gmail.com";
		sendKeys(By.id("email"), emailString);
	}
	
	@Given("I have entered missingEmail")
	public void i_have_entered_missingEmail() {
		sendKeys(By.id("email"), "");
	}

	@And("I have also entered username")
	public void i_also_have_entered() {
		Random rand = new Random();
		int randomInt = rand.nextInt(1000000);
		emailString = "marie" + randomInt + "abc";
		sendKeys(By.id("new_username"), emailString);
	}
	
	@And("I have also entered longUsername")
	public void longUsername() {
		sendKeys(By.id("new_username"), "abcSvenneNotToLong1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
	}
	
	@And("I have also entered usernameTaken")
	public void usernameTaken() {
		sendKeys(By.id("new_username"), "Anna");
	}

	@Given("I have entered password")
	public void i_have_entered_password() {
		sendKeys(By.name("password"), "ABCabc123&");
	}

	@When("I click on the sign up button")
	public void i_click_on_the_sign_up_button() {
		click(By.id("onetrust-accept-btn-handler"));
		click(By.id("create-account"));
	}

	@Then("I get success and get {string}")
	public void i_verify_success(String message) {
		WebElement verifyingSuccess = driver.findElement(By.cssSelector("h1[class*=margin-bottom--lv3]"));
		assertEquals(message, verifyingSuccess.getText());
		driver.quit();
	}

	@Then("I get fail and get {string}")
	public void i_verify_(String message) {
		WebElement verifyingMissingEmail = driver.findElement(By.cssSelector("span[class=invalid-error"));
		assertEquals(message, verifyingMissingEmail.getText());
		driver.quit();
	}
	
	private void click(By by) {
		(new WebDriverWait(driver,10)).until(ExpectedConditions.elementToBeClickable(by));
		driver.findElement(by).click();
		}
	
	private void sendKeys(By by, String keys) {
		(new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(by));
		driver.findElement(by).sendKeys(keys);
	}
}
