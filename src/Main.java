import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidArmorException, InvalidWeaponException {
        Scanner scan = new Scanner(System.in);

            runMenu();
    }

    static void runMenu() throws InvalidArmorException, InvalidWeaponException {

        Weapon mightyAxe = new Weapon("sword", 2, SLOT.WEAPON, WEAPON_TYPE.SWORD, 10, 0.8);
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to your new adventure!");
        System.out.print("Enter your name: ");
        String userName = scan.next();
        System.out.println("Which class do you wish to be?: ");
        System.out.println("1. Mage");
        System.out.println("2. Ranger");
        System.out.println("3. Rogue");
        System.out.println("4. Warrior");
        System.out.print("Enter the number of the class: ");
        int classChoice = scan.nextInt();
        Mage newMage = new Mage(userName);
        Ranger newRanger = new Ranger(userName);
        Rogue newRogue = new Rogue(userName);
        Warrior newWarrior = new Warrior(userName);
        while (true) {
            System.out.println("\n================================================");
            System.out.println("Okey " + userName + "... What do you want to do next? ");
            System.out.println("1. Level up");
            System.out.println("2. Equip weapon");
            System.out.println("3. Equip armor");
            System.out.println("4. Character sheet");
            System.out.println("5. Exit system");
            System.out.print("Make your choice -> ");
            int menuChoice = scan.nextInt();
            if (menuChoice == 1) {
                if (classChoice == 1) {
                    newMage.levelUp();
                } else if (classChoice == 2) {
                    newRanger.levelUp();
                } else if (classChoice == 3) {
                    newRogue.levelUp();
                } else if (classChoice == 4) {
                    newWarrior.levelUp();
                }
            }
            if (menuChoice == 2) {
                System.out.println("Which weapon do you want to equip?");
                if (classChoice == 1) {
                    System.out.println("Name | Required Level | Damage | Attacks per second");
                    System.out.println("1. Staff | 1 | 10 | 0.8");
                    System.out.print("Choose the weapon you want to equip -> ");
                    int weaponChoice = scan.nextInt();
                    if (weaponChoice == 1) {
                        Weapon weapon = new Weapon("Staff", 1, SLOT.WEAPON, WEAPON_TYPE.STAFF, 10, 0.8);
                        newMage.equipItem(weapon);
                        System.out.println("\nEquipped " + weapon.name);
                    }
                } else if (classChoice == 2) {
                    System.out.println("Name | Required Level | Damage | Attacks per second");
                    System.out.println("1. Bow | 1 | 30 | 0.8");
                    System.out.print("Choose the weapon you want to equip -> ");
                    int weaponChoice = scan.nextInt();
                    if (weaponChoice == 1) {
                        Weapon weapon = new Weapon("Bow", 1, SLOT.WEAPON, WEAPON_TYPE.BOW, 30, 0.8);
                        newRanger.equipItem(weapon);
                        System.out.println("\nEquipped " + weapon.name);
                    }
                } else if (classChoice == 3) {
                    System.out.println("Name | Required Level | Damage | Attacks per second");
                    System.out.println("1. Dagger | 1 | 7 | 0.4");
                    System.out.print("Choose the weapon you want to equip -> ");
                    int weaponChoice = scan.nextInt();
                    if (weaponChoice == 1) {
                        Weapon weapon = new Weapon("Dagger", 1, SLOT.WEAPON, WEAPON_TYPE.DAGGER, 7, 0.4);
                        newRogue.equipItem(weapon);
                        System.out.println("\nEquipped " + weapon.name);
                    }
                } else if (classChoice == 4) {
                    System.out.println("Name | Required Level | Damage | Attacks per second");
                    System.out.println("1. Sword | 1 | 28 | 1.1");
                    System.out.print("Choose the weapon you want to equip -> ");
                    int weaponChoice = scan.nextInt();
                    if (weaponChoice == 1) {
                        Weapon weapon = new Weapon("Sword", 1, SLOT.WEAPON, WEAPON_TYPE.SWORD, 28, 1.1);
                        newWarrior.equipItem(weapon);
                        System.out.println("\nEquipped " + weapon.name);
                    }
                }
            }
            if (menuChoice == 3) {
                System.out.println("Which armor do you want to equip?");
                if (classChoice == 1) {
                    System.out.println("Name | Required Level | Strength | Dexterity | Intelligence");
                    System.out.println("1. Cloth | 1 | 1 | 1 | 5");
                    System.out.print("Choose the armor you want to equip -> ");
                    int armorChoice = scan.nextInt();
                    if (armorChoice == 1) {
                        Armor armor = new Armor("Cloth", 1, SLOT.HEAD, ARMOR_TYPE.MAIL, new PrimaryAttributes(1,1,5));
                        newMage.equipItem(armor);
                        System.out.println("\nEquipped " + armor.name);
                    }
                } else if (classChoice == 2) {
                    System.out.println("Name | Required Level | Strength | Dexterity | Intelligence");
                    System.out.println("1. Leather | 1 | 1 | 1 | 1");
                    System.out.print("Choose the armor you want to equip -> ");
                    int armorChoice = scan.nextInt();
                    if (armorChoice == 1) {
                        Armor armor = new Armor("Leather", 1, SLOT.HEAD, ARMOR_TYPE.MAIL, new PrimaryAttributes(1,4,1));
                        newRanger.equipItem(armor);
                        System.out.println("\nEquipped " + armor.name);
                    }
                } else if (classChoice == 3) {
                    System.out.println("Name | Required Level | Strength | Dexterity | Intelligence");
                    System.out.println("1. Mail | 1 | 1 | 1 | 1");
                    System.out.print("Choose the armor you want to equip -> ");
                    int armorChoice = scan.nextInt();
                    if (armorChoice == 1) {
                        Armor armor = new Armor("Mail", 1, SLOT.HEAD, ARMOR_TYPE.MAIL, new PrimaryAttributes(2,4,1));
                        newRogue.equipItem(armor);
                        System.out.println("\nEquipped " + armor.name);
                    }
                } else if (classChoice == 4) {
                    System.out.println("Name | Required Level | Strength | Dexterity | Intelligence");
                    System.out.println("1. Plate | 1 | 1 | 1 | 1");
                    System.out.print("Choose the armor you want to equip -> ");
                    int armorChoice = scan.nextInt();
                    if (armorChoice == 1) {
                        Armor armor = new Armor("Plate", 1, SLOT.HEAD, ARMOR_TYPE.MAIL, new PrimaryAttributes(6,1,1));
                        newWarrior.equipItem(armor);
                        System.out.println("\nEquipped " + armor.name);
                    }
                }
            }
            if (menuChoice == 4) {
                if (classChoice == 1) {
                    System.out.println("\n" + newMage.toString());
                } else if (classChoice == 2) {
                    System.out.println("\n" + newRanger.toString());
                } else if (classChoice == 3) {
                    System.out.println("\n" + newRogue.toString());
                } else if (classChoice == 4) {
                    System.out.println("\n" + newWarrior.toString());
                }
            }
            if (menuChoice == 5) {
                System.out.println("\nShutting down program...");
                System.exit(0);
            }
            if (menuChoice < 1 || menuChoice > 5) {
                System.out.println("\nNot a valid menu choice, try again");
            }
        }

    }
}
