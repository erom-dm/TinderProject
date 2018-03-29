package basic.bits;
import java.util.*;

public class ModifyNumber {


        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int number = in.nextInt();
            int position = in.nextInt();
            int mask = (int) Math.pow(2, position - 1);

            if ((number & mask) == 0) {
                System.out.println(number);
                return;
            };

            System.out.println(number^mask);


        }

    }


