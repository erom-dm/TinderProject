package basic.jcf;

import java.util.*;

public class Main {

    public static void main(String[] args) {
      /*  Set<Integer> set = new HashSet<>();
        System.out.println(set.isEmpty());
        for (int i = 0; i < 10; i++) {
            set.add(i);

        }
        List<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(1);
        System.out.println(set);
        System.out.println(list);
        set.addAll(list);
        System.out.println(set);
        /*for (Integer element:set) {
            System.out.println(element);
        }*/
        //System.out.println(set);
        //set.remove(3);
        //set.add(1);
        // System.out.println(set);
        // System.out.println(set.contains(3));
        //System.out.println(set.contains(1));
        // System.out.println(set.size());
        // System.out.println(set.isEmpty());
        // set.clear();
        //System.out.println(set);
        // */
       /* Set<List <Integer>> set = new HashSet<>();
        set.add(Arrays.asList(1,2,3,4));
        set.add(Arrays.asList(5,6,7,8));
        System.out.println(set);
        set.add(Arrays.asList(1,2,3,4));
        System.out.println(set);
        set.add(Arrays.asList(2,1,3,4));
        System.out.println(set);
        */
        Integer [] mus = new Integer[100];
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            mus[i] = random.nextInt(9);
        }
        Set<Integer> set = new HashSet<>();
        /*for (int element: mus) {
            set.add(element);
        }
        System.out.println(set);
        */
        set.addAll(Arrays.asList(mus));
        System.out.println(set);

    }
}
