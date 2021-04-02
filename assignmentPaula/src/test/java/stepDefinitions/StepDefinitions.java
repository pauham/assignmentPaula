package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
	WebDriver driver;
	
	@Given("I have navigated at Mailchimp")
	public void i_have_navigated_at_mailchimp() throws InterruptedException {

		System.out.println("Log in");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\paula\\eclipse\\java-2020-09\\eclipse\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://login.mailchimp.com/signup/");
		Thread.sleep(1000);
	}

	@Given("I have entered {string}")
	public void i_have_entered(String string) throws InterruptedException {
		System.out.println("first");
		WebElement email = driver.findElement(By.id("email"));
		email.click();
		email.sendKeys("email");
		Thread.sleep(1000);
	}

	@And("I have also entered {string}")
	public void i_also_have_entered(String string) throws InterruptedException {
		System.out.println("third");
		WebElement userName = driver.findElement(By.name("username"));
		userName.sendKeys("username");
		Thread.sleep(1000);
	}
	
	@Given("I have entered password")
	public void i_have_entered_password() throws InterruptedException {
		System.out.println("second");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("password");
		Thread.sleep(1000);
	}

	@When("I click on the sign up button")
	public void i_click_on_the_sign_up_button() throws InterruptedException {
		System.out.println("fourth");
		WebElement signUp = driver.findElement(By.id("create-account"));
		Thread.sleep(1000);
	}

	@Then("I get {string}")
	public void i_get(String string) {
		System.out.println("fifth");
		driver.quit();
	}
}
