package hu.nive.ujratervezes.kepesitovizsga.army;

//Minden kardforgatónak van pajzsa, amivel kivédi az első őt ért csapást.
//A pajzs az első kapott sebzés 100%-át felfogja, majd összetörik, tovább nem használható.
//(Tárold le attribútumban, hogy a pajzsa ép-e vagy sem!
//Ez alapján dönts a sebzésről! Az első sufferDamage hívás után módosítsd az attribútum értékét!)

public class Swordsman extends MilitaryUnit {
    boolean hasShield;


    public Swordsman(boolean armoured) {
        super();
        setDamage(10);
        setHitPoints(100);
        hasShield = true;

    }

    @Override
    public int doDamage() {
        return this.getDamage();
    }

    @Override
    public void sufferDamage(int damage) {

        // Kérdés: Mi a szabály, ha egyszerre két páncél van?

        int vitalityAfterDamage;

        if (armored) {
            vitalityAfterDamage = this.getHitPoints() - (damage/2);
        }
        else vitalityAfterDamage = this.getHitPoints() - damage;

        if (hasShield = true) vitalityAfterDamage = this.getHitPoints();

        hasShield = false;

        this.setHitPoints(vitalityAfterDamage);


    }
}
