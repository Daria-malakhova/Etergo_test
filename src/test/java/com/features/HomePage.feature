@HomePage
Feature: Etergo Technical Assessment Homepage validation

  Customer should be able to use Zoom function from Homepage by
  ZoomIn button
  ZoomOut button

  Scenario: Validate Etergo Technical Assessment Homepage
    Given Customer is on Etergo HomePage
    Then Validate the elements on Etergo HomePage

  Scenario:Validate ZoomIn function in Etergo Technical Assessment Homepage
    Given Customer is on Etergo HomePage
    When Customer clicks on ZoomIn button
    Then Validate Zoom value is increased by 25%

  Scenario: Validate ZoomOut function in Etergo Technical Assessment Homepage
    Given Customer is on Etergo HomePage
    When Customer clicks on ZoomOut button
    Then Validate Zoom value is decreased by 25%

  Scenario: Validate Maximum value for ZoomIn function in Etergo Technical Assessment Homepage
    Given Customer is on Etergo HomePage
    When Customer clicks on ZoomIn button for Maximum limit
    Then Validate ZoomIn button is disabled

  Scenario: Validate Maximum value for ZoomOut function in Etergo Technical Assessment Homepage
    Given Customer is on Etergo HomePage
    When Customer clicks on ZoomOut button for Maximum limit
    Then Validate ZoomOut button is disabled

