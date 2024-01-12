package model.warrior;

import model.equipment.Equipment;
import model.equipment.defensiveequipment.DefensiveEquipment;
import model.weapon.Weapon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represent a Warrior.
 */
public abstract class Warrior {
    private Integer hitPoints;
    private Weapon weapon;

    private final ArrayList<Equipment> equipments = new ArrayList<>();

    public Warrior(Integer hitPoints, Weapon weapon) {
        this.hitPoints = hitPoints;
        this.weapon = weapon;
    }

    /**
     * Getter is named hitPoints instead of getHitPoints to better fit the tests.
     * @return the hitPoints of the warrior.
     */
    public Integer hitPoints() {
        return hitPoints;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public ArrayList<Equipment> getEquipments() {
        return equipments;
    }

    /**
     * Reduce the hit points of the warrior.
     * The resulted hit points cannot be negative.
     * @param amount the amount to reduce.
     */
    public void reduceHitPoints(Integer amount) {
        this.hitPoints = Math.max(this.hitPoints - amount, 0);
    }

    /**
     * Manage the defense of the warrior.
     * @param attackWeapon the weapon of the attacker
     */
    public void manageDefense(Weapon attackWeapon) {
        List<DefensiveEquipment> defensiveEquipments = getAllDefensiveEquipments();

        // Si le Warrior n'a pas d'équipements de défense, il subit la totalité de l'attaque.
        if (defensiveEquipments.isEmpty()) {
            reduceHitPoints(attackWeapon.getDamage());
            return;
        }

        // Prenons le premier equipment.
        DefensiveEquipment defensiveEquipment = defensiveEquipments.get(0);
        defensiveEquipment.applyDefensiveEffectWhenAttacked(attackWeapon);
    }

    public void engage(Warrior otherWarrior) {
        while(hitPoints > 0 && otherWarrior.hitPoints > 0) {
            otherWarrior.manageDefense(weapon);
            manageDefense(otherWarrior.weapon);
        }
    }

    public void addEquipment(Equipment equipment) {
        equipments.add(equipment);
    }

    public abstract Warrior equip(String equipmentName);

    public List<DefensiveEquipment> getAllDefensiveEquipments() {
        List<DefensiveEquipment> defensiveEquipments = new ArrayList<>(Collections.emptyList());

        for (Equipment equipment : equipments) {
            if (equipment instanceof DefensiveEquipment) {
                defensiveEquipments.add((DefensiveEquipment) equipment);
            }
        }
        return defensiveEquipments;
    }
}
