#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Invalid username feature
    @negative
    Scenario Outline: Invalid username test
    Given I am on Demo Blaze site
    Then click on Sign up 
    When username field is visible and editable
    Then I enter "<invalidusername>"
    Then invalid username entered
    
    

    Examples: 
      | invalidusername |
      | invalid-ARCHANA |
      | !@#$ |
      | EF%+j[1j-AK({afN54$@1XCPFf?]U)MDR5UG:3HCHz}[0GUWb2B=e:BK-F]+3kHBd7PMpv)ay[Uukz3d1.0.Bz9-%Nj2qc3H-Am/ |
      | |
      |                    |
      | null |