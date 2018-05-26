package iter;

import java.util.Arrays;
import java.util.Iterator;

public class Months implements Iterable<String> {
    private final String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    private final int size = months.length;

    //@Override
    public Iterator<String> iterator1() {
        return new Iterator<String>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index+1 <= size;
            }

            @Override
            public String next() {
                return months[index++];
            }
        };
    }

    @Override
    public Iterator<String> iterator() {
        return Arrays.asList(months).iterator();
    }
}
