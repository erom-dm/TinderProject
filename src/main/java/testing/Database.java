package testing;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private final String[] names = {"Alex", "Masha", "Dima", "Igor", "Sasha", "Lena"};
    private final String[] surNames = {"Petrenko", "Sydorenko", "Vinnichenko", "Shevchenko", "Moskalenko", "Savchenko"};
    private final int quantity;
    private final int salaryMin = 10000;
    private final int salaryMax = 100000;
    private final int yearMin = 2000;
    private final int yearMax = 2016;
    private final int rangeMin = 100000;
    private final int rangeMax = 999999;

    public Database(int quantity) {
        this.quantity = quantity;
    }

    int generateValueFromRange(int min, int max) {

    }


    List<Person> get() {
        ArrayList<Person> people = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            people.add(generateNewPerson());
        }
        return people;
    }

    private Person generateNewPerson() {
        return null;
    }
}
