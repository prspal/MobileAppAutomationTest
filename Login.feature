Feature: Verify Login page UI & Functionality

  Scenario: Verify Login page UI with no previous logins
    Given myTaxi app is installed
     When myTaxi app is opened
     Then Verify that textfield "Username" & "Password" is present
      And Verify that single button "Login" is present
  
  Scenario: Verify persistent login
    Given myTaxi app is installed
      And "User" has successfuly logged in and left the app
     When myTaxi app is opened again
     Then Verify that page with "my taxi" in title is present
      And Verify that menu key is present next to title
  
  Scenario: Verify textbox behavior for "Username"
    Given User is at login UI
     When User enters text in field "Username"
     Then Verify that default large textfield caption becomes small field title
  
  Scenario: Verify textbox behavior for "Password"
    Given User is at login UI
     When User enters password text in field "Password"
     Then Verify that default large textfield caption becomes small field title
  
  Scenario: Verify login functionality for invalid user
    Given User is at login page
     When User provides invalid username & password
     Then Verify that login page is still present
      And Snack notification shoud appear at bottom of screen
      And Snack notification should say "Login failed"
      And Snack notification should go away after 2 secs
    
  Scenario: Verify login functionality for valid user
    Given User is at login page
     When User provides valid username & password
     Then Verify that page with "my taxi" in title is present
      And Verify that menu key is present next to title
   
