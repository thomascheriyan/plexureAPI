Feature: Login to Plexure purchase API

  Scenario Outline: To verify that the user is able to authenticate successfully to Plexure API
    Given I make a request to the Plexure login API -GET https://qatestapi.azurewebsites.net/api/login 
    When I login to the API endpoint <endpoint> using <username> and <password>, response code 200 returned
    Then I get the valid successful response returned
    Examples:
    |username 									 |password	|endpoint|
    |Tester											 |Plexure123|/login	 |
    
    Scenario Outline: To verify that the user gets valid error message if username or password is missed
    Given I make a request to the Plexure login API -GET https://qatestapi.azurewebsites.net/api/login 
    When I login to the API endpoint <endpoint> using <username> and <password>, response code 400 returned
    Then I get the valid mising error response returned
    Examples:
    |username 									 |password	|endpoint|
    |														 |					|/login	 |
    
   Scenario Outline: To verify that the user gets valid error message if username or password isn't matched
    Given I make a request to the Plexure login API -GET https://qatestapi.azurewebsites.net/api/login 
    When I login to the API endpoint <endpoint> using <username> and <password>, response code 401 returned
    Then I get the valid unauthorized response returned
    Examples:
    |username 									 |password	|endpoint|
    |Invalid										 |Plexure123|/login	 |
    |Tester											 |Invalid		|/login	 |
    
  #Scenario: To verify that the user is able to purchase a pre-set product
    #Given I make a request to the Plexure purchase API -GET https://qatestapi.azurewebsites.net/api/purchase 
    #When I authenticate to the API
    #Then I get the purchased pre-set product ID returned successfully
    