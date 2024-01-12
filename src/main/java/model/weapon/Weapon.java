package model.weapon;

/**
 * Weapon used by a Warrior.
 */
public class Weapon {
    private Integer damage;

    public Weapon(Integer damage) {
        this.damage = damage;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }
}
