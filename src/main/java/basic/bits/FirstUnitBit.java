package basic.bits;

import java.util.Scanner;

public class FirstUnitBit {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        if(number ==0){
            System.out.println(number);
            return ;
        }
        int counter = 1;

        while ((number & 1)==0) {
            number=number>>1;
            counter++;


        }
        System.out.println(counter);
    }
}
