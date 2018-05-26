package optional;

import java.util.HashMap;
import java.util.Optional;

public class OptionalSample {

    public static void m1(Optional<Integer> opt) {
        opt.isPresent();
        opt.ifPresent(integer -> System.out.println("I am "+integer));
    }

    public static void m2(Optional<Integer> opt) {
        Integer integer = opt.orElse(5);
        System.out.println(integer);
    }

    public static void m4() {
        HashMap<Integer, String> map = new HashMap<>();
        map.get(11);
        map.getOrDefault(11,"Not Found");
        if (!map.containsKey(11)) {

        }
    }

    public static void main(String[] args) {
        Optional<Integer> i1 = Optional.empty();
        Optional<Integer> i2 = Optional.of(55);

        m1(i1);
        m1(i2);

        boolean present = i1.isPresent();
        Integer integer = i2.get();
    }
}
