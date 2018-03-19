package com.danit;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int n = 20;
        Integer[] array = new Integer[n];

        for (int i = 0; i < n; ++i) {
            array[i] = new Random().nextInt(1000);
        }

        int element = array[new Random().nextInt(n)];

        Arrays.sort(array);

        System.out.println(element);
        System.out.println(binarySearch(array, element));
    }

    public static int binarySearch(Integer[] array, int element) {
        int start = 0;
        int end = array.length - 1;

        while(start <= end) {
            int middle = (start + end) / 2; //index of the middle element
            if(array[middle] == element) {
                return middle;
            }

            if(array[middle] > element) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }

        }
        return -1; // index that does not exist


    }
}
