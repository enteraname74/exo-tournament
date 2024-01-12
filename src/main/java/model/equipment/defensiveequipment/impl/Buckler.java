package model.equipment.defensiveequipment.impl;

import model.equipment.defensiveequipment.DefensiveEquipment;
import model.warrior.Warrior;
import model.weapon.Weapon;
import model.weapon.impl.HandAxe;

public class Buckler extends DefensiveEquipment {
    private Integer totalBlocked = 0;
    private Boolean hasLastAttackBeenBlocked = false;
    private Boolean isActive = true;

    public Buckler(Warrior warrior) {
        super("buckler", warrior);
    }

    private void blockAttack(Weapon attackerWeapon) {
        boolean weaponsIsAxe = attackerWeapon instanceof HandAxe;
        if (weaponsIsAxe) {
            totalBlocked += 1;
            isActive = totalBlocked < 3;
        }
    }

    @Override
    public void applyDefensiveEffectWhenAttacked(Weapon attackerWeapon) {
        if (hasLastAttackBeenBlocked || !isActive) {
            getWarrior().reduceHitPoints(attackerWeapon.getDamage());
        } else {
            blockAttack(attackerWeapon);
        }
        hasLastAttackBeenBlocked = !hasLastAttackBeenBlocked;
    }
}
