package hu.nive.ujratervezes.kepesitovizsga.jurassic;

//Hozd létre a JurassicPark osztályt,
// ami konstruktor paraméterben kapja meg az adatbáziseléréshez szükséges DataSource példányt.
//Az osztályban egyetlen publikus metódus van,
// checkOverpopulation néven,
// ami térjen vissza azoknak a fajtáknak a nevével, amiknél a valós létszám magasabb, mint az elvárt
// (a fenti példában a Maiasaurus, a Velociraptor és a Hypsilophodontida),
// ABC szerint növekvő sorrendben.
//Ha az adatbázis üres, akkor a metódus térjen vissza üres listával.

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JurassicPark {

    MariaDbDataSource dataSource;

    public JurassicPark(MariaDbDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> checkOverpopulation() {

        try (Connection connection = dataSource.getConnection();
        ) {
            List<String> outPutListDinosaurBreedsActualOverExpected = new ArrayList<>();

            try (ResultSet resultSet = connection.createStatement().executeQuery(
                    "SELECT breed FROM dinosaur WHERE actual > expected ORDER BY breed");) {
                while (resultSet.next()) {
                    String dinosaurBreed = resultSet.getString("breed");
                    outPutListDinosaurBreedsActualOverExpected.add(dinosaurBreed);

                }
                //while sikeres lefutása után visszatérünk a listával, ami esetleg üres
                return outPutListDinosaurBreedsActualOverExpected;
            }
        }
        catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot execute the query.", sqlException);
        }

    }
}
