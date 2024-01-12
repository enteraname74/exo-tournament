package model.equipment;

/**
 * Equipment to be equipped on a warrior.
 */
public class Equipment {
    private final String equipmentName;

    public Equipment(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getEquipmentName() {
        return equipmentName;
    }
}
