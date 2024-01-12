package model.warrior.impl;

import model.equipment.Equipment;
import model.equipment.EquipmentFactory;
import model.warrior.Warrior;
import model.weapon.impl.HandSword;

import java.util.Optional;

public class Swordsman extends Warrior {
    @Override
    public Swordsman equip(String equipmentName) {
        Optional<Equipment> equipment = EquipmentFactory.buildEquipmentFromName(equipmentName, this);
        equipment.ifPresent(this::addEquipment);
        return this;
    }

    @Override
    public String toString() {
        return "Swordsman";
    }

    public Swordsman() {
        super(100, new HandSword());
    }
}
