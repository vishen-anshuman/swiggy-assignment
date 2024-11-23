public class GameOrchestrator {

    public static Player orchestrateGame(Player playerA, Player playerB) {
        Player attacker = determineInitialAttacker(playerA, playerB);
        Player defender = (attacker == playerA) ? playerB : playerA;
        System.out.printf("Game is Beginning with Player %s as attacker and Player %s as defender \n", attacker.getName(),
                defender.getName());
        return startBattle(attacker, defender);
    }

    static Player determineInitialAttacker(Player playerA, Player playerB) {
        return (playerA.getHealth() < playerB.getHealth()) ? playerA : playerB;
    }

    static Player startBattle(Player attacker, Player defender) {
        int round = 1;
        while (true) {
            System.out.printf("Before round %d, health score of Players are: %s (%d) and %s (%d)%n \n",
                    round,
                    attacker.getName(), attacker.getHealth(),
                    defender.getName(), defender.getHealth());

            int attackRoll = GameUtils.getDiceRoll();
            int defendRoll = GameUtils.getDiceRoll();

            int attackDamage = GameUtils.getAttackDamage(attacker, attackRoll);
            int defendStrength = GameUtils.getDefendingStrength(defender, defendRoll);
            int healthDamage = GameUtils.getHealthDamage(attackDamage, defendStrength);
            System.out.printf(
                    "Attack: %s rolled %d (Damage: %d), Defense: %s rolled %d (Strength: %d), Health Damage: %d%n \n",
                    attacker.getName(), attackRoll, attackDamage,
                    defender.getName(), defendRoll, defendStrength,
                    healthDamage
            );

            try {
                defender.setHealthAfterDamage(healthDamage);
            } catch (Exception e) {
                System.out.printf("Winner is %s \n", attacker.getName());
                return attacker;
            }
            System.out.printf("After round %d, health score of Players are: %s (%d) and %s (%d)%n \n",
                    round,
                    attacker.getName(), attacker.getHealth(),
                    defender.getName(), defender.getHealth());

            Player temp = attacker;
            attacker = defender;
            defender = temp;
            round++;
        }
    }
}
