import java.util.HashMap;

public abstract class Character {
    /* Properties */
    String name;
    int level;
    PrimaryAttributes primaryAttributes;
    HashMap<SLOT, Item> equipment;




    /* Constructors */
    public Character() {
    }

    public Character(String name, int level, PrimaryAttributes primaryAttributes, HashMap<SLOT, Item> equipment) {
        this.name = name;
        this.level = level;
        this.primaryAttributes = primaryAttributes;
        this.equipment = equipment;
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

    public HashMap<SLOT, Item> getEquipment() {
        return equipment;
    }

    public void setEquipment(HashMap<SLOT, Item> equipment) {
        this.equipment = equipment;
    }

    /* Methods */
    abstract void levelUp ();

}
