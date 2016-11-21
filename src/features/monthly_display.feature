Feature: Allow users to view the month a shoe was or will be released in.

  Scenario:
  User clicks on a months URL and views the shoes that are or will be released.
    Given a user is on the home page
    When A user clicks on the month page
      | January    |
      | February   |
      | March      |
      | April      |
      | May        |
      | June       |
      | July       |
      | July       |
      | August     |
      | September  |
      | October    |
      | November   |
      | December   |
    Then the montly page should load.
    Then a list of shoes with a description, image, and MSRP should be displayed
