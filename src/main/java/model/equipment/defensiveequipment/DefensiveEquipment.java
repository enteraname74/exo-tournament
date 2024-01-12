package model.equipment.defensiveequipment;

import model.equipment.Equipment;
import model.warrior.Warrior;
import model.weapon.Weapon;

/**
 * Defensive equipment used when attacked by another Warrior.
 */
public abstract class DefensiveEquipment extends Equipment {
    public DefensiveEquipment(String equipmentName, Warrior warrior) {
        super(equipmentName, warrior);
    }

    /**
     * Attack the warrior and apply the defensive effect on him.
     * @param attackerWeapon the weapon of the attacker.
     */
    public abstract void applyDefensiveEffectWhenAttacked(Weapon attackerWeapon);
}
