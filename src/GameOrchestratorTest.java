public class GameOrchestratorTest {

    public static void main(String[] args) {
        Player playerA = Player.builder().name("Warrior").health(100).strength(50).attack(40).build();
        Player playerB = Player.builder().name("Mage").health(80).strength(30).attack(60).build();
        testDetermineInitialAttacker(playerA, playerB);
        testStartBattle(playerA, playerB);
        testOrchestrateGame(playerA, playerB);
    }

    private static void testDetermineInitialAttacker(Player playerA, Player playerB) {
        Player attacker = GameOrchestrator.determineInitialAttacker(playerA, playerB);
        assert attacker.getName().equals("Mage") : "Test Failed: Mage should be the attacker";
        System.out.println("Test Passed: determineInitialAttacker");
    }

    private static void testStartBattle(Player playerA, Player playerB) {
        Player winner = GameOrchestrator.startBattle(playerA, playerB);
        assert winner != null : "Test Failed: Winner should not be null";
        System.out.println("Test Passed: startBattle");
    }

    private static void testOrchestrateGame(Player playerA, Player playerB) {
        Player winner = GameOrchestrator.orchestrateGame(playerA, playerB);
        assert winner != null : "Test Failed: Winner should not be null";
        System.out.println("Test Passed: orchestrateGame");
    }
}
