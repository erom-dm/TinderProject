package basic.itera;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IterSample implements Iterable<Integer> {
    private int[] a;
    private List<Integer> values;

    class Itera10 implements Iterator<Integer> {
        int pos = 0;

        @Override
        public boolean hasNext() {
            return pos<10;
        }

        @Override
        public Integer next() {
            return pos++;
        }
    }

    class Itera implements Iterator<Integer> {
        int position = 0;

        @Override
        public boolean hasNext() {
            return position<a.length;
        }

        @Override
        public Integer next() {
            return a[position++];
        }
    }

    public IterSample() {
        a = new int[10];
        for (int i = 0; i < a.length; i++) {
            a[i]=i+10;
        }
        values = new ArrayList<>();
        values.add(1);
        values.add(10);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Itera10();
        //return new Itera();
        //return values.iterator();
    }

    public static void main(String[] args) {
        IterSample is = new IterSample();
        //ArrayList<Integer> al = new ArrayList<>();
        for (int el : is) {
            System.out.println(el);
        }

    }
}
