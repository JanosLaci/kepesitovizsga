package hu.nive.ujratervezes.kepesitovizsga.addigits;

//Add digits
//Hozd létre az AddDigits osztályt, és annak az addDigits(String input) metódusát.
//A metódus feladata, hogy a paraméterben kapott Stringben található összes számjegyet adja össze,
// és ennek az összegét adja vissza.
// Ha a bemeneti String üres, vagy null, adjon vissza -1 értéket.


import java.util.HashSet;
import java.util.Set;

public class AddDigits {

    public int addDigits(String input) {

        if (input == null || input == "") return -1;

        String[] arrayOfStrings = input.split("");

        //feltételezzük, hogy 0 eredményt vár összegre, ha nincs számjegy a bemenetben
        int counterOfSum = 0;

        for (String element : arrayOfStrings) {
            if (isNumeric(element)) {
                counterOfSum += Integer.parseInt(element);
            }
        }
        return counterOfSum;
    }

    private static boolean isNumeric(String inputString) {
        //Jelen esetben fölösleges az ellenőrzés:
        //if (inputString == null || inputString.length() == 0) return false;

        //ha sikerül a parse-olás, számjegy volt az input, egyébként nem:
        try {
            Integer.parseInt(inputString);
            return true;
        } catch (NumberFormatException numberFormatException) {
            return false;
        }
    }

}
