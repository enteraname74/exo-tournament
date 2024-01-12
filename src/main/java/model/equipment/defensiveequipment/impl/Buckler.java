package model.equipment.defensiveequipment.impl;

import model.equipment.Equipment;
import model.equipment.defensiveequipment.DefensiveEquipment;
import model.warrior.Warrior;
import model.weapon.Weapon;

public class Buckler extends Equipment implements DefensiveEquipment {
    private Integer totalBlocked = 0;
    private Boolean hasLastAttackBeenBlocked = false;
    private Boolean isActive = true;

    public Buckler() {
        super("buckler");
    }

    private void blockAttack(Weapon attackerWeapon) {
        boolean weaponsIsAxe = BucklerBreaker.class.isAssignableFrom(attackerWeapon.getClass());
        if (weaponsIsAxe) {
            totalBlocked += 1;
            isActive = totalBlocked < 3;
        }
    }

    @Override
    public Integer applyDefensiveEffectWhenAttacked(Weapon attackerWeapon, Integer attackerDamage) {
        Integer returnedDamage;
        if (hasLastAttackBeenBlocked || !isActive) {
            returnedDamage = 0;
        } else {
            blockAttack(attackerWeapon);
            returnedDamage = attackerDamage;
        }
        hasLastAttackBeenBlocked = !hasLastAttackBeenBlocked;
        return returnedDamage;
    }
}
