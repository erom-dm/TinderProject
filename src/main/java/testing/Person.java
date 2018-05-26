package testing;

public interface Person extends Comparable<Person> {
    int id();
    String name();
    int salary();
    int beginYear();
    void printIt();
}
