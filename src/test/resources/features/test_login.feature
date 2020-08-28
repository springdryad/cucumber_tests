Feature: Login To Jira

  @Regression
  Scenario: Login to Jira
    Given I navigate to Jira Login Page
    And I enter user name - "RuslanaChumachenko"
    And I enter password - "RuslanaChumachenko"
    And I click on the login button
    Then I found user icon

  @Regression
  Scenario Outline: Failed Login to Jira
    Given I navigate to Jira Login Page
    And I enter user name - <user_name>
    And I enter password - <password>
    And I click on the login button
    And I debug
    Then I see error message - <expected_result>

    Examples:
      | user_name            | password             | expected_result                                                                   |
      | "RuslanaChumachenko" | "wrong_password"     | "Извините, имя пользователя или пароль неверны - пожалуйста, попробуйте еще раз." |
      | "wrong_password"     | "RuslanaChumachenko" | "Извините, имя пользователя или пароль неверны - пожалуйста, попробуйте еще раз." |