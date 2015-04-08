Feature: A player can go to the last question when he gets all wedges

  Scenario: If we have a player when the max number of wedges is 6
    And he gets 0 wedges
    Then he does not have all the questions answered

  Scenario: If we have a player when the max number of wedges is 6
    And he gets 5 wedges
    Then he does not have all the questions answered

  Scenario: If we have a player when the max number of wedges is 6
    And he gets 6 wedges
    Then he does have all the questions answered
