## GameOrchestrator.

Primary Game logic is written in GameOrchestrator Class. <br>
To run the game call orchestrateGame of GameOrchestrator, it takes to players as input and returns winner player. <br>

## GameSimulator

Game is being simulated via **Game** class, its main method call the **GameOrchestrator's orchestrateGame** method.<br>
It takes values of players from player_test_cases_updated.txt file. Each line of **player_test_cases_updated.txt** has two players, <br>
Each line has attributes of a Player example below. - <br> 
_PlayerA: Name: Druid, Health: 100, Strength: 50, Attack: 50; PlayerB: Name: Necromancer, Health: 85, Strength: 40, Attack: 75_ <br>

**Game** class also a parser to read texts form **player_test_cases_updated.txt**, and convert it into Player Object.<br>
To run the game use main method of Game. also to run with new inputs pleas change data in **player_test_cases_updated.txt** accordingly.
<br> 


## Test cases for GameOrchestrator is written in GameOrchestratorTest.java