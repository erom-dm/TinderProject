package codegym;

import java.util.Scanner;

public class DungeonMaze {
    public static void main(String[] args) {
        String s = "5 10\n" +
                "0 0 1 0\n" +
                "0 1 1 2\n" +
                "0 2 1 3\n" +
                "0 3 1 0\n" +
                "1 0 2 2\n" +
                "1 2 2 2\n" +
                "1 3 2 0\n" +
                "2 0 3 2\n" +
                "2 2 3 2\n" +
                "3 2 4 3";
        Scanner in = new Scanner(s);
        int N=in.nextInt();
        int M=in.nextInt();
        DisjointSet joints = new DisjointSet(N * N);
        for (int i = 0; i < M; i++) {
            int x1=in.nextInt();
            int y1=in.nextInt();
            int x2=in.nextInt();
            int y2=in.nextInt();
            joints.union(key(x1, y1, N),key(x2, y2, N));
        }

        for (int i = 0; i < N; i++) {
            int upKey = key(N-1, i, N);
            int count = 0;
            for (int j = 0; j < N; j++) {
                count += joints.find(upKey, key(0, j, N))?1:0;
            }
            System.out.print(count>0?count:"" +" ");
        }
    }

    private static int key(int x, int y, int N) {
        return x*N+y;
    }
}
