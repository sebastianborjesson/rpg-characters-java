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
    void levelUp() {
        this.level++;
        this.primaryAttributes = new PrimaryAttributes(
                this.primaryAttributes.strength + 1,
                this.primaryAttributes.dexterity + 4,
                this.primaryAttributes.intelligence + 1
        );
    }
    @Override
    void equipItem(Item item) throws InvalidWeaponException, InvalidArmorException {
        // Call the specific equip method depending on what type
        // of item the character wants to equip
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
        if (weapon.type == WEAPON_TYPE.DAGGER ||
            weapon.type == WEAPON_TYPE.SWORD) {
            this.equipmentSlots.put(SLOT.WEAPON, weapon);
        } else {
            throw new InvalidWeaponException("You can't equip this " + weapon.type);
        }
    }
    void equipArmor(Armor armor) throws InvalidArmorException {
        if (armor.slot == SLOT.HEAD || armor.slot == SLOT.BODY || armor.slot == SLOT.LEGS) {
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
    double getCharacterDPS() {
        Weapon weapon = (Weapon) equipmentSlots.get(SLOT.WEAPON);
        double DPSWeapon;
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
