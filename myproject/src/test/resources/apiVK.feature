Feature: Test API VK

  @postMessageToTheWall
  Scenario: Test post message to the wall
    When Post message to the wall
    Then Message is posted
   
  @editMessageAtTheWall  
  Scenario: Test edit message by id of posted message 
    When Edit message on the wall
    Then Message is edited
   
  @deleteMessageFromTheWall  
  Scenario: Test delete message by id posted message
    When Delete message from the wall
    Then Message is deleted
    
  @postPhotoToTheWall
  Scenario: Test post photo to the wall
    When Post photo by id
    Then Photo is posted