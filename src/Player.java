public class Player {
    private final String name;
    private int health;
    private final int strength;
    private final int attack;

    private Player(String name, int health, int strength, int attack) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.attack = attack;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public int getAttack() {
        return attack;
    }

    public void setHealthAfterDamage(int damage) throws Exception {
        this.health -= damage;
        if (health <= 0) {
            throw new Exception("Health must be a positive integer.");
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "health=" + health +
                ", strength=" + strength +
                ", attack=" + attack +
                ", name='" + name + '\'' +
                '}';
    }

    public static PlayerBuilder builder() {
        return new PlayerBuilder();
    }

    public static class PlayerBuilder {
        private String name;
        private int health;
        private int strength;
        private int attack;

        public PlayerBuilder health(int health) {
            if (health <= 0) {
                throw new IllegalArgumentException("Health must be a positive integer.");
            }
            this.health = health;
            return this;
        }

        public PlayerBuilder strength(int strength) {
            if (strength <= 0) {
                throw new IllegalArgumentException("Strength must be a positive integer.");
            }
            this.strength = strength;
            return this;
        }

        public PlayerBuilder attack(int attack) {
            if (attack <= 0) {
                throw new IllegalArgumentException("Attack must be a positive integer.");
            }
            this.attack = attack;
            return this;
        }

        public PlayerBuilder name(String name) {
            this.name = name;
            return this;
        }

        public Player build() {
            return new Player(this.name, this.health, this.strength, this.attack);
        }
    }
}
