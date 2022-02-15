package item;

import enums.SLOT;
/* This class is used for creating every item that the game has */
public abstract class Item {
    /* General properties that every item has  */
    public String name;
    public int requiredLevel;
    public SLOT slot;


    public Item() {
    }

    /* Constructor that is inherited down to every subclass that implements the class */
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
