Feature: Verify the Driver Profile UI & functionality
 

  Scenario: Verify the Driver info page UI 
    Given User enters valid search query 
     When User selects one of the drivers from the search results
     Then Verify that Driver ino UI is open with tile "Driver Profile"
     And Verify that Driver photo is displayed on left
     And Verify that Driver name appears in bold on right of photo
     And Verify the latest driver location is provided 
     And Verify that date-of-birth is displayed for driver
     And Verify that Phone icon is present at the bottom-right of the screen 

  Scenario: Verify the Phone functionality
    Given Driver profile page is open
     When User click the "Phone" icon at the bottom-right of the screen
     Then Verify that Phone app opens with number in the dialer

