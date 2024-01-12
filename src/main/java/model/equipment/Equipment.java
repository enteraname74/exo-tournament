package model.equipment;

import model.warrior.Warrior;

/**
 * Equipment to be equipped on a warrior.
 */
public abstract class Equipment {
    private Warrior warrior;
    private final String equipmentName;

    public Equipment(String equipmentName, Warrior warrior) {
        this.equipmentName = equipmentName;
        this.warrior = warrior;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public Warrior getWarrior() {
        return warrior;
    }

    public void setWarrior(Warrior warrior) {
        this.warrior = warrior;
    }
}
