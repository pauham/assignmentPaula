Feature: Create account
  I want to use this template for my feature file. F�rklaring om vad v�r feature �r p� eng

  Scenario Outline: Title of your scenario outline. titeln av v�rt testfall
  
  	Given I have logged in at Mailchimp
    And I have entered <email>
    When I check for the <value> in step
    Then I verify the <status> in step

    Examples: 
      | email  | value | status  |
      | "phhh.hhh@gmail.com" |     5 | success |
      | name2 |     7 | Fail    |
