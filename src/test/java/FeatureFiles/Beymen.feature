Feature: Beymen Test

  Scenario: Product Scenario
    Given Navigate to Beymen
    When Verify open the Beymen
    And First stage with search
    Then Clean the search box
    Then Second stage with search
    And Push the enter key
    And Choose a random product
    And Export selected product information to txt file
    And The selected product is added to the cart
    And Product price comparison
    And Increase the amount of product verify the product number
    Then Verify that the cart is empty by deleting the items from the cart
