public class Armor extends Item {
    ARMORTYPE type;
    PrimaryAttributes primaryAttributes;

    public Armor() {
    }

    public Armor(String name, int requiredLevel, SLOT slot) {
        super(name, requiredLevel, slot);
    }

    public Armor(String name, int requiredLevel, SLOT slot, ARMORTYPE type, PrimaryAttributes primaryAttributes) {
        super(name, requiredLevel, slot);
        this.type = type;
        this.primaryAttributes = primaryAttributes;
    }

    /* Getters and Setters */
    public ARMORTYPE getType() {
        return type;
    }

    public void setType(ARMORTYPE type) {
        this.type = type;
    }

    public PrimaryAttributes getPrimaryAttributes() {
        return primaryAttributes;
    }

    public void setPrimaryAttributes(PrimaryAttributes primaryAttributes) {
        this.primaryAttributes = primaryAttributes;
    }
}
