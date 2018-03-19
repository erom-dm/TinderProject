package com.danit;

import java.util.*;

public class FindPeak {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        java.io.PrintStream out = System.out;

        int n = in.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }
        out.println(search(array));
    }

    public static int search(int[] array) {
        int pos;
        int start = 1;
        int end = array.length - 1;

        if(array[0] > array[1]){
            return array[0];
        }
        if(array[end] > array[end-1]){
            return array[end];
        }
        end--;
        while(true){
            pos = (start + end) /2;
            if(array[pos] > array[pos-1] && array[pos] > array[pos+1]){
                return array[pos];
            }
            else if(array[pos] < array[pos-1]){
                end = pos - 1;
            }
            else{
                start = pos + 1;
            }
        }

    }

}
