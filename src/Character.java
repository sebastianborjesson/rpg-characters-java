import java.util.HashMap;
import java.util.Map;
// Would be nice with a short description of what this classed is used for
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

    public Character(String name, int level, PrimaryAttributes primaryAttributes, PrimaryAttributes totalPrimaryAttributes, HashMap<SLOT, Item> equipmentSlots) {
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

    public int getLevel() {
        return level;
    }

    public PrimaryAttributes getPrimaryAttributes() {
        return primaryAttributes;
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

    /* Methods */
    abstract void levelUp();
    abstract double getCharacterDPS();
    abstract void equipItem(Item item) throws InvalidWeaponException, InvalidArmorException;
    public abstract String toString();

}
