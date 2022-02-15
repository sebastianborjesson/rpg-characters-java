package item;

import character.PrimaryAttributes;
import enums.*;


public class Armor extends Item {
    public ARMOR_TYPE type;
    public PrimaryAttributes primaryAttributes;

    public Armor() {
    }

    public Armor(String name, int requiredLevel, SLOT slot, ARMOR_TYPE type, PrimaryAttributes primaryAttributes) {
        super(name, requiredLevel, slot);
        this.type = type;
        this.primaryAttributes = primaryAttributes;
    }
}
