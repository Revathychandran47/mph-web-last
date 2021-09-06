Feature: Validation on Your profile page positive test cases

  #User should be able to click on the your profile and edit profile details

  Scenario: Validate that the  Your Profile  title  should be present in  Your Profile screen
    Given launch the URL and open login page
    When Enter login data
    Then check Your Profile  title  should be present in  Your Profile screen

  Scenario: Verify the scenario when dialogue box will appear, when click on edit icon
    When Click on edit icon
    Then Verify the dialogue box

  Scenario: Verify the scenario when edit  the profile details
    When Edit  the profile details

  Scenario: Verify the scenario when adding Email ID in contact details
    When Add Email ID in contact details

  Scenario: Verify the scenario when Activate , Edit and  Deactivate the Email ID
    When Activate , Edit and  Deactivate the Email ID

  Scenario: Verify the scenario when add Phone Number in contact details.
    When Add Phone Number in contact details

  Scenario: Verify the scenario when Activate , Edit and  Deactivate the Phone Number
    When Activate , Edit and  Deactivate the Phone Number

  Scenario: Verify the scenario when add Address in contact details.
    When Add Address in contact details.

  Scenario: Verify the scenario when Activate , Edit , Primary and  Deactivate the Address
    When Activate , Edit , Primary and  Deactivate the Address

  Scenario: Verify the scenario when add Plan coverage
    When Add Plan coverage

  Scenario: Verify the scenario when Activate , Edit , Make primary and  Deactivate the Plan coverage
    When Activate , Edit , Make primary and  Deactivate the Plan coverage

  Scenario: Verify the scenario when change the password
    When Change the password

  Scenario: Verify the scenario when password should be displayed on clicking the eye and user can able to save the details
    When The password should be displayed on clicking the eye

    Scenario: Verify uploading of profile pic successfully
      When Click on the profile pic icon
      Then Select file and upload image
      Then Verify the successful upload