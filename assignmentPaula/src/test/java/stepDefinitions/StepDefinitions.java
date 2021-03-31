package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {


		@Given("I have logged in at Mailchimp")
		public void i_have_logged_in_at_mailchimp() throws InterruptedException {
		   System.out.println("Log in");
		   System.setProperty("webdriver.chrome.driver", "C:\\Users\\paula\\eclipse\\java-2020-09\\eclipse\\drivers\\chromedriver.exe");

		   WebDriver driver = new ChromeDriver();
		   driver.get("https://login.mailchimp.com/signup/");
		   Thread.sleep(1000);
		    
		   driver.quit();
		}

		@Given("I have entered {string}") //det som står på denna raden måste stå på samma rad som i Cucumber
		public void i_have_entered(String email) { // men på denna raden kan man ändra namnet "i_have_ent... til något annat om man vill
			System.out.println("Email" + email);
		}
		@When("I check for the {int} in step")
		public void i_check_for_the_in_step(int  userName) {
			System.out.println("Username" + userName);
		}
		@Then("I verify the success in step")
		public void i_verify_the_success_in_step() {
			System.out.println("Verify");
		}



	
}
