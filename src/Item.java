
public abstract class Item {
    String name;
    int requiredLevel;
    SLOT slot;


    public Item() {
    }

    public Item(String name, int requiredLevel, SLOT slot) {
        this.name = name;
        this.requiredLevel = requiredLevel;
        this.slot = slot;
    }

    /* Getters and Setters */
    public String getName() {
        return name;
    }

    public SLOT getSlot() {
        return slot;
    }

    public void setSlot(SLOT slot) {
        this.slot = slot;
    }
}
