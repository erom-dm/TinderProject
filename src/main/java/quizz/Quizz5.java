package quizz;

import java.util.*;

public class Quizz5 {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        System.out.println(a.getClass().getSimpleName());

        Set<Integer> s = new HashSet<Integer>();
        System.out.println(s.getClass().getSimpleName());

        Map<Integer, String> x1 = new HashMap<>();
        System.out.println(x1.getClass().getSimpleName());

        Map<Integer, String> x = new HashMap<Integer, String>() {{
            put(1, "A");
            put(2, "B");
            put(3, "C");
        }};
        System.out.println(x.getClass().getSimpleName());
        System.out.println(x.getClass().getName());
        Map<Integer, String> x2 = new HashMap<Integer, String>() {{
            put(1, "A");
            put(2, "B");
            put(3, "C");
        }};
        System.out.println(x2.getClass().getName());
    }
}
