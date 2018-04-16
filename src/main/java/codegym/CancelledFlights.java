package codegym;

import java.util.*;

public class CancelledFlights {
    final int FROM=0;
    final int TO=1;
    private DisjointSet joints;
    private int[][] flights;
    private boolean[] cancelled;

    private void readFlights() {
        joints.clear();
        for (int i = 0; i < flights.length; i++) {
            if (!cancelled[i]) {
                joints.union(flights[i][FROM], flights[i][TO]);
            }
        }
    }

    private void cancel(int index) {
        cancelled[index]=true;
    }

    private boolean isConnected(int src, int dst) {
        return joints.find(src, dst);
    }

    public static void main(String[] args) {
        CancelledFlights cf = new CancelledFlights();

        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        int F = in.nextInt();
        cf.flights = new int[F][2];
        cf.cancelled = new boolean[F];
        cf.joints = new DisjointSet(A);
        // read flights to array
        for (int i = 0; i < F; i++) {
            cf.flights[i][cf.FROM]=in.nextInt();
            cf.flights[i][cf.TO]=in.nextInt();
        }
        cf.readFlights();
        // read test
        while (in.hasNext()) {
            String command = in.next();
            if ("cancel".equals(command)) {
                int flight = in.nextInt();
                cf.cancel(flight);
                cf.readFlights();
            } else {
                int from = in.nextInt();
                int to = in.nextInt();
                System.out.println(cf.isConnected(from, to)?"true":"false");
            }
        }
    }
}