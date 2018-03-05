public class Main {

    public static void main(String[] args) {
        int n = 10;
        int[] cash = new int[n+1];
        System.out.println(fibo(n, cash));
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

}
