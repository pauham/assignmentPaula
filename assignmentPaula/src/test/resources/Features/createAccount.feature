Feature: Create account
  I want to use this template for my feature file. Förklaring om vad vår feature är på eng

  Scenario Outline: Title of your scenario outline. titeln av vårt testfall
  
  	Given I have logged in at Mailchimp
    And I have entered <email>
    When I check for the <value> in step
    Then I verify the <status> in step

    Examples: 
      | email  | value | status  |
      | "phhh.hhh@gmail.com" |     5 | success |
      | name2 |     7 | Fail    |
