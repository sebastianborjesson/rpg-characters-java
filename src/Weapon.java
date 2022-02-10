public class Weapon extends Item {
    /* Properties */
    WEAPONTYPE type;
    double damage;
    double APS; // APS = Attacks per second

    /* Constructors */
    public Weapon() {
    }

    public Weapon(String name, int requiredLevel, SLOT slot, WEAPONTYPE type, double damage, double APS) {
        super(name, requiredLevel, slot);
        this.type = type;
        this.damage = damage;
        this.APS = APS;
    }

    /* Getters and Setters */
    public WEAPONTYPE getType() {
        return type;
    }

    public void setType(WEAPONTYPE type) {
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
