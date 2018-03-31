package basic.binary_heap;

import java.util.*;
public class Solution_Kmax {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt(); //k-th max element

        Comparator<Integer> c = new Comparator<Integer>() {
            @Override
            public int compare(Integer value1, Integer value2) {
                return value2-value1;
            }
        };

        PriorityQueue<Integer> pq = new PriorityQueue<>(c);
        while(in.hasNext()) {
            pq.add(in.nextInt());
        }
        int el=0;
        for (int i = 0; i < k; i++) {
            el=pq.poll();
        }
        System.out.println(el);
    }
}