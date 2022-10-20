Feature: Artist Publication
  Scenario: Make a Successful Post
    Given that the user is on your main page
    When you click on the “Publications” section
    And fill everything correctly
    And click the "Publish" button
    Then the publication will be successfully created.
  Scenario: Posting incorrectly
    Given that the user is on your main page
    When you click on the “Publications” section
    And do not fill out the entire form
    And click the "Publish" button
    Then the post will not be created.