package model.weapon.impl;

import model.equipment.defensiveequipment.impl.BucklerBreaker;
import model.weapon.Weapon;

public class HandAxe extends Weapon implements BucklerBreaker {
    public HandAxe() {
        super(6);
    }
}
