public class Player {
    private int health;
    private int strength;
    private int attack;

    private Player(Builder builder) {
        this.health = builder.health;
        this.strength = builder.strength;
        this.attack = builder.attack;
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

    public void setHealth(int health) {
        if (health <= 0) {
            throw new IllegalArgumentException("Health must be a positive integer.");
        }
        this.health = health;
    }

    public void setStrength(int strength) {
        if (strength <= 0) {
            throw new IllegalArgumentException("Strength must be a positive integer.");
        }
        this.strength = strength;
    }

    public void setAttack(int attack) {
        if (attack <= 0) {
            throw new IllegalArgumentException("Attack must be a positive integer.");
        }
        this.attack = attack;
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

        public Player build() {
            return new Player(this);
        }
    }
}
