Feature: user
  As a user of the website I want to be able to enter a vehicle registration number and get
  the correct make and colour of the cars I own back from the website.

  Background: DVLA user in on the DVLA website
    Given DVLA user in on the vehicle check website

  Scenario: The user enters a valid registration plate
    When User enters values from testdata CSV file
    Then User will be shown the correct make and colour as per expected CSV values

  Scenario: The user enters a invalid registration plate
    When User enters invalid registration plate
    Then User will be shown an invalid error message

  Scenario: The user enters a empty registration plate details
    When User enters nothing in registration box
    Then User will be shown an invalid error message