package com.danit;

import java.util.*;

public class CircularShift {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        for (int i = 0; i < k; i++) {
            int memo = n&1;
            //System.out.println(Integer.toBinaryString(memo));
            n= n>>>1;
            //System.out.println(Integer.toBinaryString(n));
            memo=memo<<31;
            n=n|memo;
            //System.out.println(Integer.toBinaryString(n));
            //System.out.println();
        }
        System.out.println(n);
    }

}