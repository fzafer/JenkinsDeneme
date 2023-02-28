Feature: The application should be running

  @smoke @test1
  Scenario: simple search
    Given I am on the home page
    When I search for "wooden spoon"
    Then I should see the results

  @regression @test2
  Scenario: another search
    Given I am on the home page
    When I search for "useless box"
    Then I should see more results

  @smoke
  Scenario: Search functionality result title verification
    Given user is on Google search page
    When user types apple and clicks enter
    Then user sees apple in the google title