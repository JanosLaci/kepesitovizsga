package hu.nive.ujratervezes.kepesitovizsga.army;

//A lovasság a csatát rohammal indítja,
// így minden lovas első támadása háromszoros sebzést okoz,
// az utána következők egyszereset.
//(Azaz az első doDamage meghívása háromszoros értéket ad vissza,
// a többi egyszeres értéket.
// Tárold le egy attribútumban, hogy hanyadik támadás van,
// azaz hányszor került meghívásra a doDamage metódus, és ez alapján dönts!)

public class HeavyCavalry extends MilitaryUnit {
    boolean isItFirstDoDamage;

    public HeavyCavalry() {
        setDamage(20);
        setHitPoints(150);
        setArmored(true);
        isItFirstDoDamage = true;
    }

    @Override
    public int doDamage() {

        if (isItFirstDoDamage) {
            isItFirstDoDamage=false;
            return this.getDamage()*3;
        }
        else{
            isItFirstDoDamage=false;
            return this.getDamage();
        }
    }

    @Override
    public void sufferDamage(int damage) {
        int vitalityAfterDamage;

        if (armored) {
            vitalityAfterDamage = this.getHitPoints() - (damage/2);
        }
        else vitalityAfterDamage = this.getHitPoints() - damage;

        this.setHitPoints(vitalityAfterDamage);
    }
}
