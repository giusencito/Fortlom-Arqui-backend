Feature: Premium Qualities
  Scenario: Publication of Events correctly
    Given that the artist is in the "Event" section,
    When you click on “Post Event”
    And fill in the data correctly
    And click on “Create and Post”
    Then an event will be successfully created.
  Scenario: Publishing Events incorrectly
    Given that the artist is in the "Event" section,
    When you click on “Post Event”
    And do not fill in the form data
    And click on “Create and Post”
    Then event will not be created


