package model.warrior.impl;

import model.warrior.Warrior;
import model.weapon.impl.GreatSword;

public class Highlander extends Warrior {
    public Highlander() {
        super(120, new GreatSword());
    }

    public Highlander(String elt) {
        super(10, new GreatSword());
    }

    @Override
    public Warrior equip(String equipment) {
        return null;
    }
}
