Feature: LogIn
  Background: user is on homepage

  @login
  Scenario Outline:  User can navigate to log in page
  So that user can  longin .
    Given user is on login page
    When user enter "<user name>" and "<password>"
    Then user can not log in successufully with invalid user name or password
    Examples:
      | password |user name|error message|
      |        | asasas@yhaooo.com|Login was unsuccessful. Please correct the errors and try again.No customer account found|

