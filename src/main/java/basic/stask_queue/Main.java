package basic.stask_queue;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        int maxsum = 0;
        for (int i = 0; i < K; i++) {
            int s = in.nextInt();
            queue.add(s);
            maxsum += s;
        }
        int sum = maxsum;
        for (int i = K; i < N; i++) {
            int first = queue.poll();
            int s = in.nextInt();
            queue.add(s);
            sum = sum - first + s;
            maxsum = Math.max (maxsum, sum);
        }
        System.out.println(maxsum);


    }
}


