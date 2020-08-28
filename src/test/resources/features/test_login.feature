Feature: Jira tests

  Background: Login to Jira
    Given I navigate to Jira Login Page
    And I enter user name - "RuslanaChumachenko"
    And I enter password - "RuslanaChumachenko"
    And I click on the login button

  @Regression
  Scenario: Successful login to Jira
    Then I found user icon

  @Regression
  Scenario: Create issue in Jira
    And I click Create Issue button
    And I enter Project - "Webinar"
    And I enter Issue Type - "Task"
    And I enter Summary - "Ruslana's task #3"
    And I enter Reporter - "RuslanaChumachenko"
    And I enter Description - "Sample description"
    And I click to submit issue
    And I debug
    Then I see issue created pop up - "WEBINAR"


#  @Regression
#  Scenario Outline: Failed login to Jira
#    Given I navigate to Jira Login Page
#    And I enter user name - <user_name>
#    And I enter password - <password>
#    And I click on the login button
#    And I debug
#    Then I see error message - <expected_result>
#
#    Examples:
#      | user_name            | password             | expected_result                                                                   |
#      | "RuslanaChumachenko" | "wrong_password"     | "Извините, имя пользователя или пароль неверны - пожалуйста, попробуйте еще раз." |
#      | "wrong_password"     | "RuslanaChumachenko" | "Извините, имя пользователя или пароль неверны - пожалуйста, попробуйте еще раз." |


