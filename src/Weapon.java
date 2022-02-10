public class Weapon extends Item {
    /* Properties */
    WEAPON_TYPE type;
    double damage;
    double APS; // APS = Attacks per second

    /* Constructors */
    public Weapon() {
    }

    public Weapon(String name, int requiredLevel, SLOT slot, WEAPON_TYPE type, double damage, double APS) {
        super(name, requiredLevel, slot);
        this.type = type;
        this.damage = damage;
        this.APS = APS;
    }

    /* Getters and Setters */
    public WEAPON_TYPE getType() {
        return type;
    }

    public void setType(WEAPON_TYPE type) {
        this.type = type;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public double getAPS() {
        return APS;
    }

    public void setAPS(double APS) {
        this.APS = APS;
    }
}
