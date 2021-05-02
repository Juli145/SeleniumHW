Feature: Global page check

  Scenario: Global page check
    Given I open Main page
    And I click button RandomName
    And I click dropdown
    And I click chosen domain
    And I remember email
    And I open settings
    And I wait for settings to be opened
    And I remember secret address
    And I close settings
    And I check that settings are closed
   # And I check text "В ожидании новых писем..." displayed
  And I click write button

