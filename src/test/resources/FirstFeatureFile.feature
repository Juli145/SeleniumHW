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
    And I wait for write button visibility
    And I check that send letter form is displayed
    And I fill in field To in send letter form
    And I fill in field Subject in send letter form
    And I fill in field Text in send letter form
    And I click Send button
    And I wait for new letter
    And I wait for letter to be opened
    And I check that letter email matches
    And I check that letter subject matches
    And I check that letter text matches
    And I click Reply button
    And I wait for write button visibility
    And I fill in field Text in reply letter form
    And I click Send button
    And I click Back button
    And I wait for Main page to be opened
    And I check that new letter subject matches
    And I open new letter
    And I wait for write button visibility
    And I check that new letter text matches
    And I click Delete letter button
    And I confirm letter delete
    And I wait for Main page to be opened
    And I check that new letter is gone




