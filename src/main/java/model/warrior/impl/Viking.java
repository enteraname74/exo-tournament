package model.warrior.impl;

import model.equipment.Equipment;
import model.equipment.EquipmentFactory;
import model.warrior.Warrior;
import model.weapon.impl.HandAxe;

import java.util.Optional;

public class Viking extends Warrior {
    public Viking() {
        super(120, new HandAxe());
    }

    @Override
    public String toString() {
        return "Viking";
    }

    @Override
    public Viking equip(String equipmentName) {
        Optional<Equipment> equipment = EquipmentFactory.buildEquipmentFromName(equipmentName, this);
        equipment.ifPresent(this::addEquipment);
        return this;
    }
}
