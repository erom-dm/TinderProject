package testing;

import java.util.List;

public class PersonTest {

    public static void main(String[] args) {
        List<Person> people = new Database(25).get();
        people.forEach(System.out::println);
    }
}
