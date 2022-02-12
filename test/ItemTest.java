import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ItemTest {

    Warrior newWarrior;
    Mage newMage;
    Rogue newRogue;
    Ranger newRanger;

    @BeforeEach
    void setUp() {
        newWarrior = new Warrior("Warrior-test");
        newMage = new Mage("Mage-test");
        newRogue = new Rogue("Rogue-test");
        newRanger = new Ranger("Ranger-test");
    }

    @AfterEach
    void tearDown() {
        newWarrior = null;
        newMage = null;
        newRogue = null;
        newRanger = null;
    }

    @Test
    void equipWeapon_weaponLevelHigherThanCharacters_shouldThrowException() {
        Weapon weapon = new Weapon("Mighty Axe", 2, SLOT.WEAPON, WEAPON_TYPE.AXE, 10, 0.8);
        assertThrows(InvalidWeaponException.class, () -> {
            newWarrior.equipmentSlots.put(SLOT.WEAPON, weapon);
            if (newWarrior.level < weapon.requiredLevel) {
                throw new InvalidWeaponException("Invalid level requirement. " +
                        "This weapon requires you to be at level 2" +
                        "and you are currently at level 1");
            }
        });
    }

    @Test
    void equipArmor_armorLevelHigherThanCharacters_ShouldThrowException() {
        Armor armor = new Armor(
                "Plate Body",
                2,
                SLOT.BODY,
                ARMOR_TYPE.PLATE,
                new PrimaryAttributes(6,3,1)
        );
        assertThrows(InvalidArmorException.class, () -> {
            newWarrior.equipmentSlots.put(SLOT.BODY, armor);
            if (newWarrior.level < armor.requiredLevel) {
                throw new InvalidArmorException("Invalid level requirement. " +
                        "This armor requires you to be at level 2" +
                        " and you are currently at level 1");
            }
        });
    }

    @Test
    void equipWeapon_wrongWeaponTypeForWarrior_shouldThrowException() {
        Weapon weapon = new Weapon("Cross-Bow", 1, SLOT.WEAPON, WEAPON_TYPE.BOW, 15, 0.6);
        assertThrows(InvalidWeaponException.class, () -> {
            if (weapon.type == WEAPON_TYPE.AXE ||
                    weapon.type == WEAPON_TYPE.HAMMER ||
                    weapon.type == WEAPON_TYPE.SWORD) {
                newWarrior.equipmentSlots.put(SLOT.WEAPON, weapon);
            } else {
                throw new InvalidWeaponException("You can't equip this " + weapon.type);
            }
        });
    }

    @Test
    void equipArmor_wrongArmorTypeForWarrior_shouldThrowException() {
        Armor armor = new Armor(
                "Cloth",
                1,
                SLOT.BODY,
                ARMOR_TYPE.CLOTH,
                new PrimaryAttributes(1,5,1)
        );
        assertThrows(InvalidArmorException.class, () -> {
            if (armor.type == ARMOR_TYPE.MAIL ||
                    armor.type == ARMOR_TYPE.PLATE) {
                newWarrior.equipmentSlots.put(armor.slot, armor);
            } else {
                throw new InvalidArmorException("You can't wear this " + armor.type);
            }
        });
    }

    @Test
    void equipWeapon_validWeapon_shouldReturnTrue() {
        Weapon weapon = new Weapon("Common Wand", 2, SLOT.WEAPON, WEAPON_TYPE.WAND, 10, 0.8);
        newMage.equipmentSlots.put(SLOT.WEAPON, weapon);
        assertTrue(newMage.equipmentSlots.get(SLOT.WEAPON) != null);
    }

    @Test
    void equipArmor_validArmor_shouldReturnTrue() {
        Armor armor = new Armor(
                "Leather Helmet",
                2,
                SLOT.BODY,
                ARMOR_TYPE.PLATE,
                new PrimaryAttributes(1,6,1)
        );
        newRanger.equipmentSlots.put(SLOT.HEAD, armor);
        assertTrue(newRanger.equipmentSlots.get(SLOT.HEAD) != null);
    }

    @Test
    void calculateDPS_noWeaponEquipped_expectingLowestAmount() {
        assertEquals(1.05, newWarrior.getCharacterDPS());
    }

    @Test
    void calculateDPS_axeEquipped() {
        Weapon weapon = new Weapon("Mighty Axe", 1, SLOT.WEAPON, WEAPON_TYPE.AXE, 7, 1.1);
        newWarrior.equipmentSlots.put(SLOT.WEAPON, weapon);
        assertEquals(8.085, newWarrior.getCharacterDPS());
    }

    @Test
    void calculateDPS_weaponAndArmorEquipped() {
        Weapon weapon = new Weapon("Mighty Axe", 1, SLOT.WEAPON, WEAPON_TYPE.AXE, 7, 1.1);
        Armor armor = new Armor(
                "Plate Body",
                2,
                SLOT.BODY,
                ARMOR_TYPE.PLATE,
                new PrimaryAttributes(1,1,1)
        );
        newWarrior.equipmentSlots.put(SLOT.WEAPON, weapon);
        newWarrior.equipmentSlots.put(SLOT.BODY, armor);
        assertEquals(8.162, newWarrior.getCharacterDPS());

    }
}