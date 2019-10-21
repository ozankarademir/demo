Feature: Search and add to cart lower price IphoneX
@SeleniumTests
  Scenario: Search for items and validate results
    Given User is on Amazon Landing page
    When User searched for "Iphone X" phones
    Then "iPhone X" results are displayed
    And User click the first product
    Given User is on Product detail page
    When User compare prices and add to chart of lower price item