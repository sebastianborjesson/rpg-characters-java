import java.util.HashMap;

public class Mage extends Character {


    /* Constructors */
    public Mage() {
    }

    public Mage(String name) {
        super(name, 1, new PrimaryAttributes(1,1,8), new HashMap<>());
    }

    /* Methods */
    @Override
    void levelUp() {
        this.level++;
        this.primaryAttributes = new PrimaryAttributes(
                this.primaryAttributes.strength + 1,
                this.primaryAttributes.dexterity + 1,
                this.primaryAttributes.intelligence + 5
        );
    }

    @Override
    void equipItem(Item item) throws InvalidWeaponException, InvalidArmorException {
        if (item instanceof Weapon) {
            equipWeapon((Weapon) item);
        } else if (item instanceof Armor) {
            equipArmor((Armor) item);
        }
    }

    void equipWeapon(Weapon weapon) throws InvalidWeaponException {
        if (weapon.requiredLevel > this.level) {
            throw new InvalidWeaponException("Invalid level requirement. " +
                    "This weapon requires you to be at level " + weapon.requiredLevel +
                    " and you are currently at level " + this.level);
        }
        if (weapon.slot != SLOT.WEAPON) {
            throw new InvalidWeaponException("You need to equip your weapon to the weapon slot.");
        }
        if (weapon.type == WEAPON_TYPE.STAFF ||
                weapon.type == WEAPON_TYPE.WAND) {
            this.equipmentSlots.put(SLOT.WEAPON, weapon);
        } else {
            throw new InvalidWeaponException("You can't equip this " + weapon.type);
        }
    }
    void equipArmor(Armor armor) throws InvalidArmorException {
        if (armor.slot == SLOT.HEAD || armor.slot == SLOT.BODY || armor.slot == SLOT.LEGS) {
            if (armor.type == ARMOR_TYPE.CLOTH) {
                this.equipmentSlots.put(armor.slot, armor);
            } else {
                throw new InvalidArmorException("You can't wear this " + armor.type);
            }


        }
    }
}
