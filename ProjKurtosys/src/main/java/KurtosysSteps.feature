Feature: Kurtosys White Papers

  Scenario: Verify and submit white paper form
    Given I navigate to "https://www.kurtosys.com/"
    When I navigate to the "INSIGHTS" menu
    And I select "White Papers & eBooks" from the dropdown
    Then I should see the title "White Papers"
    When I click on "UCITS Whitepaper"
    And I fill in the "First Name" field with "John"
    And I fill in the "Last Name" field with "Doe"
    And I fill in the "Company" field with "Example Inc."
    And I fill in the "Industry" field with "Finance"
    And I do not fill in the "Email" field
    And I click "Send me a copy"
    Then I should see error messages
    And I take a screenshot of the error messages