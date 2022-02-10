import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to your new adventure!");
        System.out.print("Enter your name: ");
        String userName = scan.next();
        System.out.print("Welcome " + userName + "! Which class do you wish to be? (Mage, Ranger, Rogue, Warrior): ");
        String inputedClass = scan.next();
        if (inputedClass.equals("Warrior")) {
            Warrior newWarrior = new Warrior(userName);
            System.out.println("Welcome " + newWarrior.name + " the warrior");
        }
    }
}
