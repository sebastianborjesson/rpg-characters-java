import java.util.HashMap;

public class Rogue extends Character {

    /* Constructors */
    public Rogue() {
    }

    public Rogue(String name) {
        super(name, 1, new PrimaryAttributes(2,6,1), new HashMap<>());
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
}
