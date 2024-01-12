package classes.warriors;

import classes.Warrior;
import classes.weapons.HandSword;

public class Swordsman extends Warrior {
    public Swordsman() {
        super(100, new HandSword());
    }
}
