#Author: Sujeet V
@All
Feature: Assignment for all the cases 

@GetItemCount @All 
Scenario: Testing the Compare tab Available Items Count
Given User loads the application and clicks on compare tab Selects the "Items"
Then get the available item count


@CompareOverPriced @All
Scenario: Testing the Compare tab count for Overpriced items
Given User loads the application and clicks on compare tab Selects the "Items"
Then User selects the "Overpriced" option from the Status dropdown
Then captures the item count details


@DownloadCSVAndUpload @All
Scenario: Testing if the Download Page Data(H) csv file downloading and the count present on web and downloaded csv file item count is matching
Given User loads the application and clicks on compare tab Selects the "Items"
Then User clicks the Options dropdown and selects the "Download Page Data(H)" value from the dropdown
And compare the total itmes count and downloaded csv items count and upload

@checkDifferenceButton @All
Scenario: Testing the difference button is enabled and user able to click that display differences
Given User loads the application and clicks on compare tab Selects the "Items"
Then User check if the difference button is enabled and user able to click that display differences.


@dragAndDropRelationship @All
Scenario: Testing the drag and drop functionality for Relationship chart screen
Given User loads the application and clicks on Relationship link
Then User drags "Website" and "Category" to X and Y axis then click on Apply Filter buttton and then clicks on any generated cell




