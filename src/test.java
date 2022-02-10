
public class test {
    public static void main(String[] args) throws InvalidWeaponException, InvalidArmorException {
        Warrior newWarrior = new Warrior("test");
        System.out.println(newWarrior.primaryAttributes.strength);
        newWarrior.levelUp();
        Weapon weapon = new Weapon("sword", 2, SLOT.WEAPON, WEAPON_TYPE.SWORD, 10, 0.8);
        Armor headArmor = new Armor("mail", 1, SLOT.HEAD, ARMOR_TYPE.MAIL, new PrimaryAttributes(0,1,1));
        Armor bodyArmor = new Armor("mail", 2, SLOT.BODY, ARMOR_TYPE.MAIL, new PrimaryAttributes(0,1,1));
        Armor legArmor = new Armor("mail", 1, SLOT.LEGS, ARMOR_TYPE.MAIL, new PrimaryAttributes(0,1,1));


        newWarrior.equipWeapon(weapon);
        newWarrior.equipItem(headArmor);
        newWarrior.equipItem(bodyArmor);
        newWarrior.equipItem(legArmor);
        System.out.println(newWarrior.getEquipmentSlots());
    }
}
