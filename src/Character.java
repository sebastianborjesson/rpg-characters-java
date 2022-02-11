import java.util.HashMap;
import java.util.Map;

public abstract class Character {
    /* Properties */
    protected String name;
    protected int level;
    protected PrimaryAttributes primaryAttributes;
    protected PrimaryAttributes totalPrimaryAttributes;
    protected Map<SLOT, Item> equipmentSlots = new HashMap<>();

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

    public PrimaryAttributes getTotalPrimaryAttributes() {
        int strength = 0;
        int dexterity = 0;
        int intelligence = 0;
        for (Item item: equipmentSlots.values()) {
            if (item instanceof Armor) {
                strength += ((Armor) item).primaryAttributes.strength;
                dexterity += ((Armor) item).primaryAttributes.dexterity;
                intelligence += ((Armor) item).primaryAttributes.intelligence;
            }
        }

        strength += this.primaryAttributes.strength;
        dexterity += this.primaryAttributes.dexterity;
        intelligence += this.primaryAttributes.intelligence;


        return new PrimaryAttributes(strength, dexterity, intelligence);
    }

    public void setTotalPrimaryAttributes(TotalPrimaryAttributes totalPrimaryAttributes) {
        this.totalPrimaryAttributes = totalPrimaryAttributes;
    }

    public Map<SLOT, Item> getEquipmentSlots() {
        return equipmentSlots;
    }

    public void setEquipmentSlots(HashMap<SLOT, Item> equipment) {
        this.equipmentSlots = equipment;
    }

    /* Methods */
    abstract void levelUp();
    abstract void equipItem(Item item) throws InvalidWeaponException, InvalidArmorException;
    public abstract String toString();

}
