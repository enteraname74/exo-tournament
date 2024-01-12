package classes;

/**
 * Represent a Warrior.
 */
public class Warrior {
    private Integer hitPoints;
    private Weapon weapon;

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

    public void setHitPoints(Integer hitPoints) {
        this.hitPoints = hitPoints;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    /**
     * Reduce the hit points of the warrior.
     * The resulted hit points cannot be negative.
     * @param amount the amount to reduce.
     */
    public void reduceHitPoints(Integer amount) {
        this.hitPoints = Math.max(this.hitPoints - amount, 0);
    }

    public void engage(Warrior otherWarrior) {
        while(hitPoints > 0 && otherWarrior.hitPoints > 0) {
            otherWarrior.reduceHitPoints(weapon.getDamage());
            reduceHitPoints(otherWarrior.weapon.getDamage());
        }
    }
}
