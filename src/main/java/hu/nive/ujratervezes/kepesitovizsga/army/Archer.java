package hu.nive.ujratervezes.kepesitovizsga.army;

public class Archer extends MilitaryUnit {

    public Archer() {
        super();
        setHitPoints(50);
        setDamage(20);
        setArmored(false);

    }

    @Override
    public int doDamage() {
        return this.getDamage();
    }

    @Override
    public void sufferDamage(int damage) {
        int vitalityAfterDamage;

        vitalityAfterDamage = this.getHitPoints() - damage;

        this.setHitPoints(vitalityAfterDamage);
    }
}
