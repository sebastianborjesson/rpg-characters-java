import java.util.HashMap;

public class Warrior extends Character{

    /* Constructors */
    public Warrior() {
    }

    public Warrior(String name) {
        super(name, 1, new PrimaryAttributes(5,3,2), new TotalPrimaryAttributes(5,3,2), new HashMap<>());
    }



    /* Methods */
    @Override
    void levelUp() {
        this.level++;
        this.primaryAttributes = new PrimaryAttributes(
                this.primaryAttributes.strength + 3,
                this.primaryAttributes.dexterity + 2,
                this.primaryAttributes.intelligence + 1
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
        if (weapon.type == WEAPON_TYPE.AXE ||
            weapon.type == WEAPON_TYPE.HAMMER ||
            weapon.type == WEAPON_TYPE.SWORD) {
            this.equipmentSlots.put(SLOT.WEAPON, weapon);
        } else {
            throw new InvalidWeaponException("You can't equip this " + weapon.type);
        }
    }
    void equipArmor(Armor armor) throws InvalidArmorException {
        if (armor.slot == SLOT.HEAD || armor.slot == SLOT.BODY || armor.slot == SLOT.LEGS) {
            if (armor.type == ARMOR_TYPE.MAIL ||
                armor.type == ARMOR_TYPE.PLATE) {
                this.equipmentSlots.put(armor.slot, armor);
            } else {
                throw new InvalidArmorException("You can't wear this " + armor.type);
            }


        }
    }

    @Override
    double getCharacterDPS() {
        Weapon weapon = (Weapon) equipmentSlots.get(SLOT.WEAPON);
        if (weapon == null) return 0;
        double DPSWeapon = weapon.getWeaponsDPS();
        return DPSWeapon * (1 + (double) getTotalPrimaryAttributes().strength / 100);
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
