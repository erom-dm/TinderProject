package com.danit;
import java.util.*;

public class HammingDistance {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                sum += dist(arr[i], arr[j]);
            }

        }
        System.out.println(sum);
    }

    private static int dist(int a, int b) {
        int number = a ^ b;
        int counter = 0;
        int mask = 1;
        while (number != 0) {
            counter += number & mask;
            number = number >> 1;
        }
        return counter;
    }

}
