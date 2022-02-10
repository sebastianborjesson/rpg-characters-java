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

    public void setName(String name) {
        this.name = name;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public void setRequiredLevel(int requiredLevel) {
        this.requiredLevel = requiredLevel;
    }

    public SLOT getSlot() {
        return slot;
    }

    public void setSlot(SLOT slot) {
        this.slot = slot;
    }
}
