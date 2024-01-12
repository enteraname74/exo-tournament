package model.warrior.impl;

import model.warrior.Warrior;
import model.weapon.impl.GreatSword;

public class Highlander extends Warrior {
    private Integer attacks = 0;

    public Highlander() {
        super(150, new GreatSword());
    }

    public Highlander(String elt) {
        super(10, new GreatSword());
    }

    @Override
    public Highlander equip(String equipment) {
        return null;
    }

    @Override
    public Integer manageAttack() {
        if (attacks == 2) {
            attacks = 0;
            return 0;
        }
        attacks += 1;
        return super.manageAttack();
    }

    @Override
    public String toString() {
        return "Highlander";
    }
}
