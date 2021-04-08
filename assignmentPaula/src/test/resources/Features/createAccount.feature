Feature: Create account
  I want to want to be able to create an account with different scenarios. F�rklaring om vad v�r feature �r p� eng

  Scenario Outline: Title of your scenario outline
  
  	Given I have navigated at Mailchimp
    And I have entered <email>
    And I have also entered <username>
    And I have entered password
		When I click on the sign up button
		Then I get <status> and get <message>

    Examples: 
     | email | username | status | message |
     | email |username| success | "Check your email" | #allt g�r som f�rv�ntat
     | email | longUsername | fail| "Enter a value less than 100 characters long" | #l�ngt anv�ndarnamn, mer �n 100 tecken
     | email |usernameTaken| fail | "Another user with this username already exists. Maybe it's your evil twin. Spooky." | #userName redan upptagen !!
     | missingEmail |username| fail | "Please enter a value" | #email saknas
