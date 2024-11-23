public class Player {
    private final String name;
    private int health;
    private final int strength;
    private final int attack;

    private Player( Builder builder) {
        this.name = builder.name;
        this.health = builder.health;
        this.strength = builder.strength;
        this.attack = builder.attack;
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

    public void setHealthAfterDamage(int damage) throws Exception{
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
                '}';
    }

    public static class Builder {
        public String name;
        private int health;
        private int strength;
        private int attack;

        public Builder health(int health) {
            if (health <= 0) {
                throw new IllegalArgumentException("Health must be a positive integer.");
            }
            this.health = health;
            return this;
        }

        public Builder strength(int strength) {
            if (strength <= 0) {
                throw new IllegalArgumentException("Strength must be a positive integer.");
            }
            this.strength = strength;
            return this;
        }

        public Builder attack(int attack) {
            if (attack <= 0) {
                throw new IllegalArgumentException("Attack must be a positive integer.");
            }
            this.attack = attack;
            return this;
        }


        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Player build(){
            return new Player(this);
        }
    }
}
