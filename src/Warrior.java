import java.util.HashMap;

public class Warrior extends Character{

    /* Constructors */
    public Warrior() {
    }

    public Warrior(String name) {
        super(name, 1, new PrimaryAttributes(5,3,2), new HashMap<>());
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
}
