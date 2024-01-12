package model.equipment.defensiveequipment.impl;

import model.equipment.Equipment;
import model.equipment.defensiveequipment.DefensiveEquipment;
import model.equipment.offensiveequipment.OffensiveEquipment;
import model.weapon.Weapon;

public class Armor extends Equipment implements DefensiveEquipment, OffensiveEquipment {

    public Armor() {
        super("armor");
    }

    @Override
    public Integer attackWarriorWithEffect(Weapon attackerWeapon) {
        return attackerWeapon.getDamage() - 1;
    }

    @Override
    public Integer applyDefensiveEffectWhenAttacked(Weapon attackerWeapon, Integer attackerDamage) {
        return Math.max(attackerDamage-3, 0);
    }
}
