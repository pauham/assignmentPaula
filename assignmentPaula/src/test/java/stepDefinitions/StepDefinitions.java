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
	char emailRandom;
	String emailString;
	
	@Given("I have navigated at Mailchimp")
	public void i_have_navigated_at_mailchimp() throws InterruptedException {

		System.out.println("Log in");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\paula\\eclipse\\java-2020-09\\eclipse\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://login.mailchimp.com/signup/");
		driver.manage().window().maximize();
		Thread.sleep(1000);
	}

	@Given("I have entered email") //email
	public void i_have_entered() throws InterruptedException {
		System.out.println("first");
		randomEmail(By.id("email"));
		//email.click();
		//email.sendKeys("email");
		Thread.sleep(1000);
	}
	
	@Given("I have entered missingEmail")
	public void i_have_entered_missingEmail() {
		WebElement missingEmail = driver.findElement(By.id("email"));
		missingEmail.click();
		missingEmail.sendKeys("");
	}

	@And("I have also entered username") //userName
	public void i_also_have_entered() throws InterruptedException {
		System.out.println("third");
		sentUserName(By.id("new_username"));
		//randomEmail(By.name("username"));
		//WebElement userName = driver.findElement(By.name("username"));
		//userName.sendKeys("username");
		Thread.sleep(1000);
	}
	
	@And("I have also entered longUsername")
	public void longUsername() {
		longRandomUsername(By.id("new_username"));
	}
	
	@And("I have also entered usernameTaken")
	public void usernameTaken() {
		WebElement usernameTaken = driver.findElement(By.id("new_username"));
		usernameTaken.sendKeys("Anna");
	}
	
	private void sentUserName(By by) {
		driver.findElement(by).sendKeys(emailString);	
	}

	@Given("I have entered password")
	public void i_have_entered_password() throws InterruptedException {
		System.out.println("second");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("ABCabc123&");
		Thread.sleep(1000);
	}

	@When("I click on the sign up button")
	public void i_click_on_the_sign_up_button() throws InterruptedException {
		System.out.println("fourth");
		WebElement signUp = driver.findElement(By.id("create-account"));
		signUp.click();
		//Thread.sleep(1000);
	}

	@Then("I get success")
	public void i_verify_success() {
		System.out.println("fifth");
		WebElement verifyingSuccess = driver.findElement(By.cssSelector("h1[class*=margin-bottom--lv3]"));
		assertEquals("Check your email", verifyingSuccess.getText());
		driver.quit();
	}
	
	@Then("I get failure")
	public void i_verify_failure_long_username() {
		System.out.println("fifth");
		WebElement verifyingLongUsername = driver.findElement(By.cssSelector("span[class=invalid-error"));
		assertEquals("Enter a value less than 100 characters long", verifyingLongUsername.getText());
		driver.quit();
	}
	
	@Then("I get failed")
	public void i_verify_taken_username() {
		WebElement verifyingTakenUsername = driver.findElement(By.cssSelector("span[class=invalid-error"));
		assertEquals("Another user with this username already exists. Maybe it's your evil twin. Spooky.", verifyingTakenUsername.getText());
		driver.quit();
	}
	
	@Then("I get fail")
	public void i_verify_missingEmail() {
		WebElement verifyingMissingEmail = driver.findElement(By.cssSelector("span[class=invalid-error"));
		assertEquals("Please enter a value", verifyingMissingEmail.getText());
		driver.quit();
	}
	
	private void randomEmail(By by) {
		Random rand = new Random();
		int randomInt = rand.nextInt(1000000);
		emailString = "svenne" + randomInt + "@gmail.com";
		driver.findElement(by).sendKeys(emailString);
	}
	
	private void longRandomUsername(By by) {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(by));
		driver.findElement(by).sendKeys("abcSvenneNotToLong1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
	}
}
