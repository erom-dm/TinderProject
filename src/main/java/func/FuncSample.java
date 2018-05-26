package func;

import java.util.function.Function;

public class FuncSample {

    public static void main2(Function<Integer,Integer> f, int val) {
        f.apply(val);
    }

    public static int func(int val, Function<Integer, Integer> f) {
        return f.apply(val);
    }

    public static void main(String[] args) {
        Function<Integer, Integer> funcAdd10 = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer val) {
                return val + 10;
            }
        };

        Function<Integer, Integer> funcMult2 = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer val) {
                return val * 2;
            }
        };

        Function<Integer, Integer> funcMult2v2 = val -> val * 2;

        System.out.println(func(5, funcAdd10));
        System.out.println(func(5, funcMult2));
        System.out.println(func(3, funcMult2v2));

        main2(integer -> integer/5, 555);


    }
}
