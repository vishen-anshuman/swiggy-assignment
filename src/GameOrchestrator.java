public class GameOrchestrator {

    public static Player orchestrateGame(Player playerA, Player playerB) {
        Player attacker = determineInitialAttacker(playerA, playerB);
        Player defender = (attacker == playerA) ? playerB : playerA;

        return startBattle(attacker, defender);
    }

    static Player determineInitialAttacker(Player playerA, Player playerB) {
        return (playerA.getHealth() < playerB.getHealth()) ? playerA : playerB;
    }

    static Player startBattle(Player attacker, Player defender) {
        while (true) {
            int attackRoll = GameUtils.getDiceRoll();
            int defendRoll = GameUtils.getDiceRoll();

            int attackDamage = GameUtils.getAttackDamage(attacker, attackRoll);
            int defendStrength = GameUtils.getDefendingStrength(defender, defendRoll);
            int healthDamage = GameUtils.getHealthDamage(attackDamage, defendStrength);

            try {
                defender.setHealthAfterDamage(healthDamage);
            } catch (Exception e) {
                return attacker;
            }
            Player temp = attacker;
            attacker = defender;
            defender = temp;
        }
    }
}
