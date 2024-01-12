package model.warrior;

import model.equipment.Equipment;
import model.equipment.defensiveequipment.DefensiveEquipment;
import model.equipment.offensiveequipment.OffensiveEquipment;
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
        System.out.println(this+" will take "+amount+" damages");
        this.hitPoints = Math.max(this.hitPoints - amount, 0);
    }

    /**
     * Manage one encounter between two warriors.
     * @param otherWarrior the attacked warrior.
     */
    public void manageEncounter(Warrior otherWarrior) {
        Integer attackerTotalDamage = manageAttack();
        System.out.println(this+" will deal "+attackerTotalDamage+" damages");
        otherWarrior.manageDefense(this.weapon, attackerTotalDamage);
    }

    public Integer manageAttack() {
        List<OffensiveEquipment> offensiveEquipments = getAllOffensiveEquipments();

        // Si le Warrior n'a pas d'équipements d'attaques, on retourne les dégats initiaux qu'il doit donner.
        if (offensiveEquipments.isEmpty()) {
            return getWeapon().getDamage();
        }

        Integer totalDamage = 0;
        for (OffensiveEquipment offensiveEquipment: offensiveEquipments) {
            totalDamage -= offensiveEquipment.attackWarriorWithEffect(getWeapon());
            totalDamage = Math.max(totalDamage, 0);
        }
        return totalDamage;
    }

    /**
     * Manage the defense of the warrior.
     * @param attackWeapon the weapon of the attacker
     * @param attackerDamage the damage the attacker deals after the application of his offensives equipments.
     */
    public void manageDefense(Weapon attackWeapon, Integer attackerDamage) {
        List<DefensiveEquipment> defensiveEquipments = getAllDefensiveEquipments();

        // Si le Warrior n'a pas d'équipements de défense, il subit la totalité de l'attaque.
        if (defensiveEquipments.isEmpty()) {
            reduceHitPoints(attackWeapon.getDamage());
            return;
        }

        Integer reducedDamage = attackerDamage;
        for (DefensiveEquipment defensiveEquipment: defensiveEquipments) {
            reducedDamage -= defensiveEquipment.applyDefensiveEffectWhenAttacked(attackWeapon, attackerDamage);
            reducedDamage = Math.max(reducedDamage, 0);
        }
        reduceHitPoints(reducedDamage);
    }

    public void engage(Warrior otherWarrior) {
        while(hitPoints > 0 && otherWarrior.hitPoints > 0) {
            manageEncounter(otherWarrior);
            otherWarrior.manageEncounter(this);
        }
    }

    public void addEquipment(Equipment equipment) {
        equipments.add(equipment);
    }

    public abstract Warrior equip(String equipmentName);

    public List<DefensiveEquipment> getAllDefensiveEquipments() {
        List<DefensiveEquipment> defensiveEquipments = new ArrayList<>(Collections.emptyList());

        for (Equipment equipment : equipments) {
            if (DefensiveEquipment.class.isAssignableFrom(equipment.getClass())) {
                defensiveEquipments.add((DefensiveEquipment) equipment);
            }
        }
        return defensiveEquipments;
    }

    public List<OffensiveEquipment> getAllOffensiveEquipments() {
        List<OffensiveEquipment> offensiveEquipments = new ArrayList<>(Collections.emptyList());

        for (Equipment equipment : equipments) {
            if (OffensiveEquipment.class.isAssignableFrom(equipment.getClass())) {
                offensiveEquipments.add((OffensiveEquipment) equipment);
            }
        }
        return offensiveEquipments;
    }
}
