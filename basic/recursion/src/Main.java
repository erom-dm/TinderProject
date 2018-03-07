public class Main {

    public static void main(String[] args) {
        int n = 10;
        int[] cash = new int[n+1];
//        System.out.println(fibo(n, cash));

        for (int value : cash) {
//            System.out.print(value + " ");
        }
//        System.out.println();
        System.out.println(mystery(3,50));
    }

    public static int fibo (int n, int[] cash) {

        if (n ==1 ) return 1;
        if (n==0) return 0;

        if ( cash[n] != 0) {
            return cash[n];
        }

        cash[n] = fibo(n-1, cash) + fibo(n-2, cash);
        return cash[n];
    }


    // detect problem   
    public static long mystery(long a, long b) {
        if (b == 0)     return 1;
        if (b % 2 == 0) return mystery(a*a, b/2);
        System.out.println("set");
        return mystery(a*a, b/2) * a;
    }
}
