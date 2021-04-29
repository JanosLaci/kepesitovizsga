package hu.nive.ujratervezes.kepesitovizsga.army;

public abstract class MilitaryUnit {

    int hitPoints;
    int damage;
    boolean armored;

    public MilitaryUnit() {
    }

    public MilitaryUnit(boolean armored) {
        this.armored = armored;
    }

    public abstract int doDamage();

    public abstract void sufferDamage(int damage);

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public boolean isArmored() {
        return armored;
    }


    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public void setArmored(boolean armored) {
        this.armored = armored;
    }
}
