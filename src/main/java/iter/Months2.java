package iter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Months2 {
    public static void main(String[] args) {
        final String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        List<String> m = Arrays.asList(months);
        m.forEach(System.out::println);
        System.out.println();
        m.sort((o1, o2) -> m.indexOf(o2)-m.indexOf(o1));
        m.forEach(System.out::println);
    }
}
