package model.equipment;

import model.equipment.defensiveequipment.impl.Armor;
import model.equipment.defensiveequipment.impl.Buckler;
import model.warrior.Warrior;

import java.util.Optional;

/**
 * Factory for building Equipment.
 */
public class EquipmentFactory {

    /**
     * Tries to build Equipment from its name.
     *
     * @param equipmentName the name of the equipment to build.
     * @param warrior the warrior who will receive the equipment.
     * @return an optional equipment.
     */
    public static Optional<Equipment> buildEquipmentFromName(String equipmentName, Warrior warrior) {
        switch (equipmentName) {
            case "buckler":
                return Optional.of(new Buckler());
            case "armor":
                return Optional.of(new Armor());
            default:
                return Optional.empty();
        }
    }
}
