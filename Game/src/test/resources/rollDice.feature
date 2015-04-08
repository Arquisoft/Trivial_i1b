Feature: Every time we try to get a dice instance, we should get the same one

  Scenario: If we have a dice
  	And roll the dice 1 time
    Then we should obtain 1 numbers > 0 and < 7

  Scenario: If we have a dice
  	And roll the dice 1000 time
    Then we should obtain 1000 numbers > 0 and < 7
