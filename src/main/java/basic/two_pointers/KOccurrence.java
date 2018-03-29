package basic.two_pointers;

import java.util.*;

public class KOccurrence {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();           // array length
        int m = in.nextInt();           // number
        int k = in.nextInt();           // last occurrence

        int a = -1;

        int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = in.nextInt();

            if (array[i]==m && k > 0){
                a = i;
                k--;
            }
        }
        System.out.println(a);
    }

}
