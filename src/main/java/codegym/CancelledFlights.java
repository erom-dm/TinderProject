package codegym;

import java.util.*;

public class CancelledFlights {
    final static int FROM=0;
    final static int TO=1;
    static DisjointSet joints;
    static int[][] flights;
    static boolean[] cancelled;

    private static void readFlights() {
        joints.clear();
        for (int i = 0; i < flights.length; i++) {
            if (!cancelled[i]) {
                joints.union(flights[i][FROM], flights[i][TO]);
            }
        }
    }

    private static void cancel(int index) {
        cancelled[index]=true;
    }

    private static boolean isConnected(int src, int dst) {
        return joints.find(src, dst);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        int F = in.nextInt();
        flights = new int[F][2];
        cancelled = new boolean[F];
        joints = new DisjointSet(A);
        // read flights to array
        for (int i = 0; i < F; i++) {
            flights[i][FROM]=in.nextInt();
            flights[i][TO]=in.nextInt();
        }
        readFlights();
        // read test
        while (in.hasNext()) {
            String command = in.next();
            if ("cancel".equals(command)) {
                int flight = in.nextInt();
                cancel(flight);
                readFlights();
            } else {
                int from = in.nextInt();
                int to = in.nextInt();
                System.out.println(isConnected(from, to)?"true":"false");
            }
        }
    }
}