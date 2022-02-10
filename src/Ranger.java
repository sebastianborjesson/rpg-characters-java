import java.util.HashMap;

public class Ranger extends Character {

    /* Constructors */
    public Ranger() {
    }

    public Ranger(String name) {
        super(name, 1, new PrimaryAttributes(1,7,1), new HashMap<>());
    }

    /* Methods */
    @Override
    void levelUp() {
        this.level++;
        this.primaryAttributes = new PrimaryAttributes(
                this.primaryAttributes.strength + 1,
                this.primaryAttributes.dexterity + 5,
                this.primaryAttributes.intelligence + 1
        );
    }
}
