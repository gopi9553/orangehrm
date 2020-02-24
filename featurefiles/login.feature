@tag
Feature: Admin Login
  I want to use this template OrangeHRM Admin Login

  @tag1
  Scenario: Check Admin Login with valid data
    Given I open browser with url "http://orangehrm.qedgetech.com"
    Then I should see Login Page
    When I enter username as "Admin"
    And I enter password as "Qedge123!@#"
    And I click Login
    Then I should see Admin Module
    When I close browser
	
	@tag2
  Scenario Outline: Check Admin Login with invalid data
    Given I open browser with url "<url>"
    Then I should see Login Page
    When I enter username as "<uname>"
    And I enter password as "<pword>"
    And I click Login
    Then I should see Error Message
		When I close browser
    
    Examples: 
      | url  | uname | pword  |
      |http://orangehrm.qedgetech.com|Admin|abcd|
      |http://orangehrm.qedgetech.com|abc|Qedge123!@#|
      |http://orangehrm.qedgetech.com|abc|xyz|
  