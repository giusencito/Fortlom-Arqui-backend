Feature: like Capacity
  Scenario: Liking publications
    Given that the user is in the Publication section
    And he clicks on the See Posts button
    When he sees a post he likes
    And click on the Like button
    Then he will already be indicating that he likes that post.
  Scenario: Disliking posts
    Given that the user is in the Publication section
    And clicks on the See Posts button
    When he sees a post that is not to his liking
    And click on the Dislike button
    Then you are already indicating that you do not like that post.
  Scenario: Liking events
    Given that the user is in the Event section
    And he clicks on the Show All Events button
    When he sees an event he likes
    And click on the thumbs up button
    Then he will already be indicating that he likes that event.
  Scenario: Disliking events.
    Given that the user is in the Event section
    And clicks on the Show All Events button
    When he sees an event that he does not like.
    And click on the Thumbs Down button.
    Then you will already be indicating that you do not like that event.

