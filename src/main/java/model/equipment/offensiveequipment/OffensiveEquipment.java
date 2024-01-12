package model.equipment.offensiveequipment;

import model.equipment.Equipment;
import model.warrior.Warrior;

public abstract class OffensiveEquipment extends Equipment {

    public OffensiveEquipment(String equipmentName, Warrior warrior) {
        super(equipmentName, warrior);
    }

    /**
     *
     * @param damage
     * @param otherWarrior
     */
    public abstract void attackWarriorWithEffect(Integer damage, Warrior otherWarrior);
}
