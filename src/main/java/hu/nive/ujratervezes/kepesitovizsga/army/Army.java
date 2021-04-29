package hu.nive.ujratervezes.kepesitovizsga.army;

import java.util.ArrayList;
import java.util.List;

public class Army {

    List<MilitaryUnit> militaryUnits = new ArrayList<>();

    public void addUnit(MilitaryUnit militaryUnit) {
        militaryUnits.add(militaryUnit);

    }

    public void damageAll(int damage) {
        for (MilitaryUnit unit: militaryUnits) {
            unit.sufferDamage(damage);
        }
        List<MilitaryUnit> below25Units = new ArrayList<>();

        for (MilitaryUnit unit: militaryUnits) {
            if (unit.getHitPoints() < 25) below25Units.add(unit);
        }

        militaryUnits.removeAll(below25Units);

    }

    public int getArmyDamage() {
        int totalDamage = 0;

        for (MilitaryUnit unit: militaryUnits) {
            totalDamage += unit.getDamage();
        }

        return totalDamage;
    }


    public int getArmySize() {
        return militaryUnits.size();
    }
}
