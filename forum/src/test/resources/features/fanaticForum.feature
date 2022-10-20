Feature: Fanatic Forum
  Scenario: Successful Forum Creation
    Given that the fan is in the "Fanatic Forum" section
    And click on the “+” fanatic button
    When correctly fill in the fanatic data
    And click on “Create” fanatic
    Then message will appear your forum created successfully
  Scenario: Bad Forum Creation
    Given that the fan is in the "Fanatic Forum" section
    And click on the “+” fanatic button
    When fill in the fanatic details
    And the fanatic forum name is used
    And click on “Create” fanatic
    Then message will not appear from your created fanatic forum.
  Scenario: Visualize Forum
    Given that the fan is in the "Fanatic Forum" section
    When you have successfully created a fanatic forum
    Then your forum will appear in the list