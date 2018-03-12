package com.danit;

public class Main {

    public static void main(String[] args) {

        int number = 5;
        System.out.println(findCountOfBits(number));


        if (true || false) {

        }
    }

    public static int findCountOfBits(int number) {
        int counter = 0;
        int mask = 1;

        System.out.println(Integer.toBinaryString(number));
        while (number != 0) {
            counter += number & mask;
            number = number >> 1;

            // mask = 1 << number;
            //if(number & mask == 1) {
            System.out.println(Integer.toBinaryString(number));
        }


        return (counter);
    }

    }

