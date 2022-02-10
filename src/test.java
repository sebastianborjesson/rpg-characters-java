public class test {
    public static void main(String[] args) {
        Warrior newWarrior = new Warrior("test");
        System.out.println(newWarrior.primaryAttributes.strength);
        newWarrior.levelUp();
        newWarrior.equipment.put(SLOT.HEAD, new Armor("Helmet", 1, SLOT.HEAD, ARMORTYPE.MAIL, new PrimaryAttributes(1,1,2)));
        System.out.println(newWarrior.getEquipment());
    }
}
