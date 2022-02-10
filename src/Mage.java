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
}
