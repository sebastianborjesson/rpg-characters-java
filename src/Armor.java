public class Armor extends Item {
    ARMOR_TYPE type;
    PrimaryAttributes primaryAttributes;

    public Armor() {
    }

    public Armor(String name, int requiredLevel, SLOT slot) {
        super(name, requiredLevel, slot);
    }

    public Armor(String name, int requiredLevel, SLOT slot, ARMOR_TYPE type, PrimaryAttributes primaryAttributes) {
        super(name, requiredLevel, slot);
        this.type = type;
        this.primaryAttributes = primaryAttributes;
    }

    /* Getters and Setters */
    public ARMOR_TYPE getType() {
        return type;
    }

    public void setType(ARMOR_TYPE type) {
        this.type = type;
    }

    public PrimaryAttributes getPrimaryAttributes() {
        return primaryAttributes;
    }

    public void setPrimaryAttributes(PrimaryAttributes primaryAttributes) {
        this.primaryAttributes = primaryAttributes;
    }
}
