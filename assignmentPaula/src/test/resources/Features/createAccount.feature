Feature: Create account
  I want to want to be able to create an account with different scenarios. F�rklaring om vad v�r feature �r p� eng

  Scenario Outline: Title of your scenario outline
  
  	Given I have navigated at Mailchimp
    And I have entered <email>
    And I have also entered <username>
    And I have entered password
		When I click on the sign up button
		Then I get <status>

    Examples: 
      | email | username | status |
      | email |username| success | #allt g�r som f�rv�ntat
      #| "email" |"abc"| "success" | #l�ngt anv�ndarnamn, mer �n 100 tecken
      #| "email" |"abc"| "success" | #userName redan upptagen !!
      #| "email" |"abc"| "success" | #email saknas
