package basic.recursion;

import java.util.*;

public class StonesMin {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] stones = new int[n];
        for (int i = 0; i < n; i++) {
            stones[i] = in.nextInt();
        }
        Arrays.sort(stones);
        System.out.println(recur(0,0,stones,0));
    }

    public static int recur(int sum1, int sum2, int[] stones, int index) {
        if (index == stones.length) {
            return Math.abs(sum1-sum2);
        }

        int temp1 = recur(sum1+stones[index],sum2, stones, index+1);
        int temp2 = recur(sum1, sum2+stones[index],stones, index+1);

        return Math.min(temp1,temp2);

    }
}
