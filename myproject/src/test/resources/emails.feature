Feature: Test emails pages

 @login
  Scenario: Test login page
    Given Main application page is opened
    When Enter correct user login and password
    Then Logout link is displayed
 
  @sendNewEmail
  Scenario: Test send email
    When Open new email form
    When Input data to emails
    When Click  Send email
    Then Email is sent
         
  @relocateEmailtoSpamfolder
  Scenario Outline: Test relocate emails to Spam folder
    When Click "incomming" folder link
    When Select email's checkbox by <index> index
    When Click "spam" button
    Then Email disappeared from "incomming" folder
    And Appear message about relocated email to "spam" folder
   Examples:
    | index |
    |   4   |
    |   0   |
 
 @restoreEmailFromSpamFolder
  Scenario Outline: Test restore emails from Spam to Incomming folder
    When Click "spam" folder link
    When Select email's checkbox by <index> index 
    When Click "noSpam" button
    Then Email disappeared from "spam" folder
    And Appear message about relocated email to "incomming" folder
   Examples:
    | index |
    |   1   |
    |   0   |
	
  @markFlagToAllEmails
  Scenario: Test mark flag to all emails
    When Click "incomming" folder link
    When Select all checkboxes
    When Mark email's flags
    Then All email's are marked with flag
    
  @removeFlagToAllEmails
  Scenario: Test remove flag to all emails
    When Click "incomming" folder link
    When Mark email's flags
    Then All email's flag are removed   