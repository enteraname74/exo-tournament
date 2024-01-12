package classes.warriors;

import classes.Warrior;
import classes.Weapon;
import classes.weapons.GreatSword;

public class Highlander extends Warrior {
    public Highlander() {
        super(120, new GreatSword());
    }

    public Highlander(String elt) {
        super(10, new GreatSword());
    }
}
