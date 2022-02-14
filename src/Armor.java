public class Armor extends Item {
    ARMOR_TYPE type;
    PrimaryAttributes primaryAttributes;

    public Armor() {
    }

    public Armor(String name, int requiredLevel, SLOT slot, ARMOR_TYPE type, PrimaryAttributes primaryAttributes) {
        super(name, requiredLevel, slot);
        this.type = type;
        this.primaryAttributes = primaryAttributes;
    }
}
