package com.danit;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        System.out.println(sum(nums, m));
    }

    public static int sum(int[] nums, int m){
        int sum = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int n = nums[i] + nums[j] + nums[k];

                    if (Math.abs(m - n) < Math.abs(sum - m)) {
                        sum = Math.abs(n);
                    }

                    if (Math.abs(m - sum) == 0) {
                        return sum;
                    }
                }
            }
        }

        return sum;
    }

}