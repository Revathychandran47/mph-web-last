Feature: Test refer a friend positive functionality

  #User must click on the refer a friend and navigated to refer a friend page
  Scenario: Validate that user can able to view Refer a Friend under Home page
    Given Browser is open
    When Login with valid data
    Then verify Tell your friends about Mpowered Health text and logo is displayed

  Scenario: Validate that user can able to click on Refer a Friend button
    When clicks on Refer a Friend
    And navigated to Refer a Friend landing page
    Then verify referral code text is displayed
 
  Scenario: Validate that user must be able to view the referral code text
  When clicks on 'Share Link' button
  And clicks on copy the link
  Then verify 'copied text' is displayed

  Scenario: Validate that the user should able to see a Pop Up box when clicking on 'Share a link'
    When clicks on 'Facebook'
    Then verify 'error message' is displayed

  Scenario: Validate that the user should able to copy the link
    When clicks on 'Mail'
    Then verify mail is open

  Scenario: Validate that user can view How its works
   When Login with valid mail and password
   Then clicks on 'send'

  Scenario: Validate that user can view the text Invite your friends to Mpowered Health by sharing your unique invitation code
   Given verify Invite your friends to Mpowered Health is displayed
   When clicks to slide the grid
   Then navigated to next slide

  Scenario: Validate that user can clicks on the link More information & FAQ and navigated to Frequently asked questions page
    When clicks on the link More information & FAQ
    Then verify list of Frequently asked questions
