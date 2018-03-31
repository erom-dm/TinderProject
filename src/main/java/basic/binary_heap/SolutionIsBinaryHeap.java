package basic.binary_heap;

import java.util.*;

public class SolutionIsBinaryHeap {
    static int N;

    static boolean isInRange(int index) {
        return index<N;
    }

    static int leftIndex(int parent) {
        return parent*2+1;
    }

    static int rightIndex(int parent) {
        return parent*2+2;
    }



    public static void main(String[] args) {
        String s="9\n" +
                "8 5 3 5 4 2 1 3 2";

        Scanner in = new Scanner(
      //          s
                System.in
        );
        N=in.nextInt();
        int[] input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i]=in.nextInt();
        }
        boolean heap=true;

        for (int i = 0; i < input.length; i++) {
            int leftIndex = leftIndex(i);
            int rightIndex = rightIndex(i);
            int parent = input[i];

            if (!isInRange(leftIndex) || !isInRange(rightIndex)) {
                break;
            }

            if ( parent < input[leftIndex] || parent < input[rightIndex] ) {
                //System.out.println("isn't heap");
                heap = false;
                break;
            }
            //System.out.println();
        }


        System.out.println(heap ? "is heap" : "isn't heap");
    }

}