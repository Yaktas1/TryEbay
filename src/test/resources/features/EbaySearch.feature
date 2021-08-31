@Ebay
Feature: Wiki title and search verifications

  Background: User is on the Ebay home page
    Given User is on the Ebay home page


  Scenario: Search functionality title verification
    When User searches "car" in the ebay search page
    Then User should see "car | eBay" in the ebay title
    Then User should be able to see the last item
    Then User should be able to save data





