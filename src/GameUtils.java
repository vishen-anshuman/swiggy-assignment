public class GameUtils {

    public static int getDiceRoll() {
        return (int) (Math.random() * 6) + 1;
    }

    public static int getAttackDamage(Player attacker, int roll) {
        return attacker.getAttack() * roll;
    }

    public static int getDefendingStrength(Player defender, int roll) {
        return defender.getStrength() * roll;
    }

    public static int getHealthDamage(int attackDamage, int defendingStrength) {
        if (attackDamage > defendingStrength) {
            return attackDamage - defendingStrength;
        }
        return 0;
    }
}
