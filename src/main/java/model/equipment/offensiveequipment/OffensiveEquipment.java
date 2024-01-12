package model.equipment.offensiveequipment;

import model.warrior.Warrior;
import model.weapon.Weapon;

public interface OffensiveEquipment  {

    /**
     * Return a new value of attack damage.
     * @param attackerWeapon the weapon of the attacker.
     * @return the new attack damage of the attacker.
     */
    Integer attackWarriorWithEffect(Weapon attackerWeapon);
}
