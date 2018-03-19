package com.danit;

import java.util.*;

public class SearchInRotatedArray {

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

    int middle=array.length/2;
    int start=0;
    int end=array.length-1;
    if((array.length==1)||(array[0]<array[array.length-1])){
        return array[0];
        }
        if (array[end]<array[end-1]){
        return array[end];
        }
    while (true) {
        middle = (start + end) / 2;
        if (array[middle - 1] > array[middle]) {
            return array[middle];
        }

        if (array[start] > array[middle]) {
            end = middle-1;
        } else {
            start = middle+1;
        }
    }

    /*
    if (array[middle - 1] > array[middle]) {
            return array[middle];
        }
        if (array[middle] > array[middle+1]) {
            return array[middle + 1];
        }
     */


    }

}