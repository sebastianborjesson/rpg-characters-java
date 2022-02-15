package character;

import enums.*;
import exceptions.*;
import item.*;

import java.util.HashMap;
import java.util.Map;
/* This class is used a base class for every character that is created  */
public abstract class Character {
    /* Properties */
    protected String name;
    public int level;
    protected PrimaryAttributes primaryAttributes;
    protected PrimaryAttributes totalPrimaryAttributes;
    public Map<SLOT, Item> equipmentSlots = new HashMap<>();

    /* Constructors */
    public Character() {
    }

    /* Constructor that is inherited down to every subclass that implements the class */
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
        /* Loop through your equipment slots and add the attributes to your total */
        for (Item item: equipmentSlots.values()) {
            if (item instanceof Armor) {
                strength += ((Armor) item).primaryAttributes.strength;
                dexterity += ((Armor) item).primaryAttributes.dexterity;
                intelligence += ((Armor) item).primaryAttributes.intelligence;
            }
        }

        /* Add the characters base attributes to the total */
        strength += this.primaryAttributes.strength;
        dexterity += this.primaryAttributes.dexterity;
        intelligence += this.primaryAttributes.intelligence;


        return new PrimaryAttributes(strength, dexterity, intelligence);
    }

    /* Abstract methods for characters and it's subclasses */
    public abstract void levelUp();
    public abstract double getCharacterDPS();
    public abstract void equipItem(Item item) throws InvalidWeaponException, InvalidArmorException;
    public abstract String toString();

}
