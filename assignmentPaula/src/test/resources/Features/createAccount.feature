Feature: Create account
  I want to want to be able to create an account with different scenarios. F�rklaring om vad v�r feature �r p� eng

  Scenario Outline: Title of your scenario outline
  
  	Given I have navigated at Mailchimp
    And I have entered <email>
    And I have also entered <userName>
    And I have entered password
		When I click on the sign up button
		Then I get <status>

    Examples: 
      | email | userName | status |
      | "phhh.hhh@gmail.com" |   "paula"   | "success" |
