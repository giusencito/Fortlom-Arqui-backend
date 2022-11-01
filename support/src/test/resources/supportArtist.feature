Feature: Fan capacity to support artists
  Scenario: Follow an artist
    Given that the user is in the Artists section
    When he clicks on the follow button.
    Then he will be following the artist.
  Scenario: Rate an artist
    Given that the user is in the Artists section
    When he selects a number in the bar
    Then a message will appear that the artist has been rated.
  Scenario: Do not follow an artist
    Given that the user is in the Configure section
    When he clicks on the Add button
    Then he will define his art tastes by a specific tag.