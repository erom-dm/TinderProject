package basic.bits;

import java.util.Scanner;

public class UTFValidation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        byte[] array = new byte[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextByte();
        }
        byte mask = 1;
        mask = (byte) (mask << 7);
        if (n == 1) {
            if ((array[0] & mask) == 0) {
                System.out.println("is utf-8 char");
            }
            else System.out.println("isn't utf-8 char");
        }
        else {
            mask = (byte)(1 << 7);
            mask = (byte)(mask >> (n-1));
            /*for (int i = 0; i < n; i++) {
                mask = (byte) (mask >> 1);
                byte a = 1;
                a = (byte) (a << 7);
                mask = (byte)(mask | a);
            }*/
            byte shift = (byte) (8 - n - 1);
            array[0] = (byte) (array[0] >> shift);
            array[0] = (byte) (array[0] << shift);

            if ((array[0] ^ mask) == 0) {
                for (int i = 1; i < n; i++) {
                    System.out.println(i + ": " + Integer.toBinaryString(array[i]));
                    array[i] = (byte) (array[i] >> 6 & 2);
                    System.out.println(i + ": " + Integer.toBinaryString(array[i]));
                    if (array[i] != 2){

                        // WTF?!
                        // this must be printed if array element is not equals to 2
                        System.out.println("isn't utf-8 char");
                        return;
                    }
                }
                System.out.println("is utf-8 char");
            }
            else System.out.println("isn't utf-8 char");
        }

    }
}
