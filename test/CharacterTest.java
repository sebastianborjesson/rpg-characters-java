import character.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {

    Warrior newWarrior;
    Mage newMage;
    Rogue newRogue;
    Ranger newRanger;

    // Code review Alex:
    // Reinitalizes four characters but each method only uses one at the time.
    // Suggesion: Reinitalize each variable indiviudally in each method.
    @BeforeEach
    void setUp() {
        newWarrior = new Warrior("test");
        newMage = new Mage("test2");
        newRogue = new Rogue("test3");
        newRanger = new Ranger("test4");

    }

    @AfterEach
    void tearDown() {
        newWarrior = null;
        newMage = null;
        newRogue = null;
        newRanger = null;
    }

    @Test
    void CreateCharacter_DefaultLevel_ShouldBe1() {
        assertEquals(1, newWarrior.level);
    }

    @Test
    void LevelUpCharacter_IncreaseLevelForCharacter_ShouldReturn2() {
        newMage.levelUp();
        assertEquals(2, newMage.level);
    }


    @Test
    void Mage_Attributes_ShouldBeDefault() {
        assertEquals(1, newMage.getPrimaryAttributes().strength);
        assertEquals(1, newMage.getPrimaryAttributes().dexterity);
        assertEquals(8, newMage.getPrimaryAttributes().intelligence);
    }

    @Test
    void Ranger_Attributes_ShouldBeDefault() {
        assertEquals(1, newRanger.getPrimaryAttributes().strength);
        assertEquals(7, newRanger.getPrimaryAttributes().dexterity);
        assertEquals(1, newRanger.getPrimaryAttributes().intelligence);
    }

    @Test
    void Rogue_Attributes_ShouldBeDefault() {
        assertEquals(2, newRogue.getPrimaryAttributes().strength);
        assertEquals(6, newRogue.getPrimaryAttributes().dexterity);
        assertEquals(1, newRogue.getPrimaryAttributes().intelligence);
    }

    @Test
    void Warrior_Attributes_ShouldBeDefault() {
        assertEquals( 5, newWarrior.getPrimaryAttributes().strength);
        assertEquals( 3, newWarrior.getPrimaryAttributes().dexterity);
        assertEquals(2, newWarrior.getPrimaryAttributes().intelligence);
    }

    @Test
    void Mage_AttributesChangeOnLevelUp_ShouldIncrease() {
        newMage.levelUp();
        assertEquals(2, newMage.getPrimaryAttributes().strength);
        assertEquals(2, newMage.getPrimaryAttributes().dexterity);
        assertEquals(13, newMage.getPrimaryAttributes().intelligence);
    }
    @Test
    void Ranger_AttributesChangeOnLevelUp_ShouldIncrease() {
        newRanger.levelUp();
        assertEquals(2, newRanger.getPrimaryAttributes().strength);
        assertEquals(12, newRanger.getPrimaryAttributes().dexterity);
        assertEquals(2, newRanger.getPrimaryAttributes().intelligence);

    }
    @Test
    void Rogue_AttributesChangeOnLevelUp_ShouldIncrease() {
        newRogue.levelUp();
        assertEquals(3, newRogue.getPrimaryAttributes().strength);
        assertEquals(10, newRogue.getPrimaryAttributes().dexterity);
        assertEquals(2, newRogue.getPrimaryAttributes().intelligence);
    }
    @Test
    void Warrior_AttributesChangeOnLevelUp_ShouldIncrease() {
        newWarrior.levelUp();
        assertEquals(8, newWarrior.getPrimaryAttributes().strength);
        assertEquals(5, newWarrior.getPrimaryAttributes().dexterity);
        assertEquals(3, newWarrior.getPrimaryAttributes().intelligence);
    }




}