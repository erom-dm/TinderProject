package basic.jcf;

import java.util.*;

public class ArrayListSortFirst {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4, 1, 2, 3, 5, 6, 7, 8, -1, -2, -3, -4);
        System.out.println(list);

        list.sort((n1, n2)-> {
            int o1 = Math.abs(n1 % 2);
            int o2 = Math.abs(n2 % 2);
            if (o1 > o2) {
                return 1;
            }
            if (o1 < o2) {
                return -1;
            }
            if(! n1.equals(n2)) {
                if (o1 == o2) {
                    return o1 == 0 ? n1 - n2 : n2 - n1;
                }
            }
            return 0;
        });

        System.out.println(list);



    }
}
