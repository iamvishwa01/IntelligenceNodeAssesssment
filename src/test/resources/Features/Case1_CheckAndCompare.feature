#Author: Sujeet V
@All
Feature: Assignment for all the cases 

@GetItemCount @All 
Scenario: Testing the Compare tab count
Given User loads the application and clicks on compare tab Selects the "Map Violation"
Then captures the item count details


@CompareOverPriced @All
Scenario: Testing the Compare tab count for Overpriced items
Given User loads the application and clicks on compare tab Selects the "Items"
Then User selects the "Overpriced" option from the Status dropdown
Then captures the item count details


@DownloadCSVAndUpload @All
Scenario: Testing the Compare tab count for Overpriced items
Given User loads the application and clicks on compare tab Selects the "Items"
Then User clicks the Options dropdown and selects the "Download Page Data(H)" value from the dropdown
And compare the total itmes count and downloaded csv items count

@checkDifferenceButton @All
Scenario: Testing the Compare tab count for Overpriced items
Given User loads the application and clicks on compare tab Selects the "Items"
Then User check if the difference button is enabled and user able to click that display differences.


#@dragAndDropRelationship @All
#Scenario: Testing the Compare tab count for Overpriced items
#Given User loads the application and clicks on Relationship link
#Then User drags "Website" and "Category" to X and Y axis then click on Apply Filter buttton and then clicks on any generated cell




