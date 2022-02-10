import java.util.HashMap;

public abstract class Character {
    /* Properties */
    String name;
    int level;
    PrimaryAttributes primaryAttributes;
    TotalPrimaryAttributes totalPrimaryAttributes;
    HashMap<SLOT, Item> equipmentSlots;

    /* Constructors */
    public Character() {
    }

    public Character(String name, int level, PrimaryAttributes primaryAttributes, TotalPrimaryAttributes totalPrimaryAttributes, HashMap<SLOT, Item> equipmentSlots) {
        this.name = name;
        this.level = level;
        this.primaryAttributes = primaryAttributes;
        this.totalPrimaryAttributes = totalPrimaryAttributes;
        this.equipmentSlots = equipmentSlots;
    }

    /* Getters and Setters */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public PrimaryAttributes getPrimaryAttributes() {
        return primaryAttributes;
    }

    public void setPrimaryAttributes(PrimaryAttributes primaryAttributes) {
        this.primaryAttributes = primaryAttributes;
    }

    public TotalPrimaryAttributes getTotalPrimaryAttributes() {
        return totalPrimaryAttributes;
    }

    public void setTotalPrimaryAttributes(TotalPrimaryAttributes totalPrimaryAttributes) {
        this.totalPrimaryAttributes = totalPrimaryAttributes;
    }

    public HashMap<SLOT, Item> getEquipmentSlots() {
        return equipmentSlots;
    }

    public void setEquipmentSlots(HashMap<SLOT, Item> equipment) {
        this.equipmentSlots = equipment;
    }

    /* Methods */
    abstract void levelUp();
    abstract void equipItem(Item item) throws InvalidWeaponException, InvalidArmorException;
    abstract TotalPrimaryAttributes calculateTPA ();

}
