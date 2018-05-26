package quizz;

import java.util.HashSet;

public class Quizz3 {
    public static void main(String[] args) {
        HashSet<Short> set = new HashSet<>();
        System.out.println(set.size());
        for (short i = 0; i < 100; i++) {
            set.add(i);
            set.remove((short)(i-1));
        }
        System.out.println(set);
        System.out.println(set.size());
    }
}
