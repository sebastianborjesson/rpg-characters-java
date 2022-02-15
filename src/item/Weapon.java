package item;

import enums.*;

public class Weapon extends Item {
    /* Properties */
    public WEAPON_TYPE type;
    public double damage;
    public double APS; // APS = Attacks per second

    /* Constructors */
    public Weapon() {
    }

    public Weapon(String name, int requiredLevel, SLOT slot, WEAPON_TYPE type, double damage, double APS) {
        super(name, requiredLevel, slot);
        this.type = type;
        this.damage = damage;
        this.APS = APS;
    }

    /* Methods */
    public double getWeaponsDPS() {
        return damage * APS;
    }
}
