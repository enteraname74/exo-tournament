package model.equipment.defensiveequipment;

import model.equipment.Equipment;
import model.warrior.Warrior;
import model.weapon.Weapon;

/**
 * Defensive equipment used when attacked by another Warrior.
 */
public interface DefensiveEquipment {
    /**
     * Apply a defensive effect and return the reduced damage to apply to the warrior.
     * @param attackerWeapon the weapon of the attacker.
     * @param attackerDamage the damage the attack deals after the application of his offensives equipments.
     */
    Integer applyDefensiveEffectWhenAttacked(Weapon attackerWeapon, Integer attackerDamage);
}
