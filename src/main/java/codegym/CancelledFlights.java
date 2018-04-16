package codegym;

import java.util.*;

public class CancelledFlights {
    private final int FROM=0;
    private final int TO=1;
    private DisjointSet joints;
    private int[][] flights;
    private boolean[] cancelled;
    private Scanner in = new Scanner(System.in);

    private void readFlightsToArray() {
        for (int i = 0; i < flights.length; i++) {
            this.flights[i][this.FROM]=in.nextInt();
            this.flights[i][this.TO]=in.nextInt();
        }
        this.flightsToDisjoints();
    }

    private void flightsToDisjoints() {
        joints.clear();
        for (int i = 0; i < flights.length; i++) {
            if (!cancelled[i]) {
                joints.union(flights[i][FROM], flights[i][TO]);
            }
        }
    }

    private void cancel(int index) {
        cancelled[index]=true;
        this.flightsToDisjoints();
    }

    private boolean isConnected(int src, int dst) {
        return joints.find(src, dst);
    }

    public static void main(String[] args) {
        CancelledFlights cf = new CancelledFlights();

        int A = cf.in.nextInt();
        int F = cf.in.nextInt();
        cf.flights = new int[F][2];
        cf.cancelled = new boolean[F];
        cf.joints = new DisjointSet(A);
        // read flights to array
        cf.readFlightsToArray();
        // read test
        while (cf.in.hasNext()) {
            String command = cf.in.next();
            if ("cancel".equals(command)) {
                int flight = cf.in.nextInt();
                cf.cancel(flight);
            } else {
                int from = cf.in.nextInt();
                int to = cf.in.nextInt();
                System.out.println(cf.isConnected(from, to)?"true":"false");
            }
        }
    }
}