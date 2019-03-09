 @filterFeature
 Feature: Test Booking Filter

 @listIsNotEmpty
 Scenario: Test Are hotels in city
   Given Open main application page
   When Input  "Kiev" in city field
   When Input date of travel in date form
   When Click search button
   Then Is any hotel in filter list

 @ratingMoreThanValue
 Scenario Outline: Test Is rating of first hotel in  filter list
   Given Open main application page
   When Input  "<city>" in city field
   When Input date of travel in date form
   When Click search button
   And Apply filter by score and review
   And Open list of hotels
   Then Compare is rating more than value '9'
     Examples: 
      | city   | 
      | Moskow | 
      | London |   