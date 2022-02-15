package character;

import exceptions.*;
import item.*;
import enums.*;

import java.util.HashMap;

public class Rogue extends Character {

    /* Constructors */
    public Rogue() {
    }

    public Rogue(String name) {
        super(name, 1, new PrimaryAttributes(2,6,1), new PrimaryAttributes(2,6,1) , new HashMap<>());
    }

    /* Methods */
    @Override
    public void levelUp() {
        this.level++;
        // Boost the attributes accordingly to the class
        this.primaryAttributes = new PrimaryAttributes(
                this.primaryAttributes.strength + 1,
                this.primaryAttributes.dexterity + 4,
                this.primaryAttributes.intelligence + 1
        );
    }
    @Override
    public void equipItem(Item item) throws InvalidWeaponException, InvalidArmorException {
        /* First check is for which type of item the character is trying to equip,
         *  Based on the type we cast the object to the specific type and call a separate function
         *  That sends the item in as a parameter
         */
        if (item instanceof Weapon) {
            equipWeapon((Weapon) item);
        } else if (item instanceof Armor) {
            equipArmor((Armor) item);
        }
    }

    void equipWeapon(Weapon weapon) throws InvalidWeaponException {
        /*
         * First we check the required level field on the weapon
         * If it is higher than the user's level, throw an error message
         * */
        if (weapon.requiredLevel > this.level) {
            throw new InvalidWeaponException("Invalid level requirement. " +
                    "This weapon requires you to be at level " + weapon.requiredLevel +
                    " and you are currently at level " + this.level);
        }
        /*
         * If the user is not equipping the weapon to right equipment slot, throw an error message
         * */
        if (weapon.slot != SLOT.WEAPON) {
            throw new InvalidWeaponException("You need to equip your weapon to the weapon slot.");
        }
        /*
         * We check if the weapon type is applicable to the character
         * If it is, equip the weapon to the weapon slot on your character
         * */
        if (weapon.type == WEAPON_TYPE.DAGGER ||
            weapon.type == WEAPON_TYPE.SWORD) {
            this.equipmentSlots.put(SLOT.WEAPON, weapon);
        } else {
            throw new InvalidWeaponException("You can't equip this " + weapon.type);
        }
    }
    void equipArmor(Armor armor) throws InvalidArmorException {
        /* First we check if the slot is of the right type, meaning that it is not the weapon slot */
        if (armor.slot == SLOT.HEAD || armor.slot == SLOT.BODY || armor.slot == SLOT.LEGS) {
            /*
             * We check if the armor type is applicable to the character
             * If it is, equip the armor to the specific slot on your character
             * */
            if (armor.type == ARMOR_TYPE.MAIL ||
                    armor.type == ARMOR_TYPE.LEATHER) {
                this.equipmentSlots.put(armor.slot, armor);
            } else {
                throw new InvalidArmorException("You can't wear this " + armor.type);
            }
        } else {
            throw new InvalidArmorException("You can't wear a weapon on this slot");
        }
    }

    @Override
    public double getCharacterDPS() {
        Weapon weapon = (Weapon) equipmentSlots.get(SLOT.WEAPON);
        double DPSWeapon;
        /* If no weapon is equipped, set the DPSWeapon to one
         *  Else, get the dps from the weapon class method */
        if (weapon == null) {
            DPSWeapon = 1;
        } else {
            DPSWeapon = weapon.getWeaponsDPS();
        }
        return DPSWeapon * (1 + (double) getTotalPrimaryAttributes().dexterity / 100);
    }

    @Override
    public String toString() {
        Class c = this.getClass();
        return
                "Name: " + getName() +
                "\nClass: " + c.getSimpleName() +
                "\nLevel: " + getLevel() +
                "\nStrength: " +getTotalPrimaryAttributes().strength +
                "\nDexterity: " + getTotalPrimaryAttributes().dexterity +
                "\nIntelligence: " + getTotalPrimaryAttributes().intelligence +
                "\nDPS: " + getCharacterDPS();
    }
}
