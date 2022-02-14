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

    /* Methods */
    public double getWeaponsDPS() {
        return damage * APS;
    }
}
