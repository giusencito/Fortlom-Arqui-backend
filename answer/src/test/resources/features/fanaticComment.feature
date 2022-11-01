Feature: fanatic comments
  Scenario: Creation of comments in Publication
  Given that the fan is in the Publication section.
  And click on the see Posts button
  When he chooses a publication of his choice
  And type what he wants
    And click on the Post Comment button
  Then your fanatic comment will be created successfully
  Scenario: Creation of comments in Forum
    Given that the fan is in the section Fanatic Forum
    And choose the forum of your choice
    When write what he wants in the chosen forum
    And click on the OK button
    Then a message will be displayed that the comment was successfully created.
  Scenario: Display of comments in
    Given that the fan is in the Publication section.
    And click on the see Posts button
    When he chooses a publication
    And click on the See button
    Then it will be possible to see the comments of the publication.