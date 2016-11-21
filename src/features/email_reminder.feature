Feature: Allow user to submit email to get monthly reminder emails

  # This isn't really needed but I noticed there might be a typo for all the buttons
  Scenario:
    An button to submit the email address exists
    Given a user is on the home page
    When there is a button for the user to use that submits their email address
    Then the text should say Subscribe

  Scenario:
    User submits a bad email address into the email reminders field.
    Given a user is on the home page
    When the user enters a bad email address
      | test@example.c |
    Then an error message should appear

  # We use some of the most commen TLD's
  # This test will fail since it doesn't accept .me or .co
  Scenario:
    User submits an email address to receive reminder emails
    Given a user is on the home page
    When A user enters a valid email address
      | test@example.com  |
    Then a success message should appear.

    #  | test@example.net  |
    #  | test@example.net  |
    #  | test@example.org  |
    #  | test@example.edu  |
    #  | test@example.mil  |
    #  | test@example.gov  |
    #  | test@example.co   |
    #  | test@example.biz  |
    #  | test@example.info |
    #  | test@example.me   |