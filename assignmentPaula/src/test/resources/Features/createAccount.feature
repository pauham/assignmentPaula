Feature: Create account
  I want to want to be able to create an account with different scenarios.

  Scenario Outline: To create accounts on Mailchimp
  
  	Given I have navigated at Mailchimp
    And I have entered <email>
    And I have also entered <username>
    And I have entered password
		When I click on the sign up button
		Then I get <status> and get <message>

    Examples: 
     | email | username | status | message |
   	 | email |username| success | "Check your email" |
     | email | longUsername | fail| "Enter a value less than 100 characters long" |
     | email |usernameTaken| fail | "Another user with this username already exists. Maybe it's your evil twin. Spooky." |
     | missingEmail |username| fail | "Please enter a value" |