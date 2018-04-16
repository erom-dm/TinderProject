package codegym;

import java.io.FileNotFoundException;
import java.util.*;

public class IsConnected {

    public static class DS {
        public int[] joints;

        DS(int N) {
            joints = new int[N];
            //basic initialisation
            for (int i = 0; i < N; i++) {
                joints[i] = i;
            }
        }

        public void union(int i, int j){
            int root = Math.min(root(i), root(j));
            int tail = Math.max(root(i), root(j));
            replace(root, tail);
        }

        private void replace(int src, int dst) {
            for (int i = 0; i < joints.length; i++) {
                if(joints[i] == src){
                    joints[i] = dst;
                }
            }
        }

        public boolean find(int i, int j){
            return root(i) == root(j);
        }

        private int root(int i){
            return joints[i];
        }
    }

    public static String scannerData() {
        return "16 12\n" +
                "2 10\n" +
                "3 7\n" +
                "3 6\n" +
                "4 9\n" +
                "4 13\n" +
                "4 11\n" +
                "5 6\n" +
                "6 12\n" +
                "6 11\n" +
                "7 11\n" +
                "9 11\n" +
                "10 11\n" +
                "8\n" +
                "7 4\n" +
                "0 15\n" +
                "9 2\n" +
                "10 7\n" +
                "1 7\n" +
                "13 2\n" +
                "6 8\n" +
                "5 4";
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(
                //new File("1.txt")
                scannerData()
                //System.in
        );
        int N = in.nextInt();
        int M = in.nextInt();
        DS ds = new DS(N);
        // read data
        for(int i = 0; i < M; i++){
            int i1 = in.nextInt();
            int i2 = in.nextInt();
            ds.union(i1,i2);
        }
        // check whether the vertex are connected.
        int L = in.nextInt();
        for(int i = 0; i < L; i++){
            System.out.println(ds.find(in.nextInt(),in.nextInt())?"connected" : "not connected");
        }
    }
}