package codegym;

import java.util.Scanner;

public class SingleIsolatedSubgraph {
    public static void main(String[] args) {
        String s = "5\n" +
                "\n" +
                "1 0 0 0 1\n" +
                "0 0 0 0 0\n" +
                "0 0 1 0 0\n" +
                "0 0 0 0 0\n" +
                "1 0 1 0 0";

        Scanner in = new Scanner(
//                System.in
                s
        );

        int N = in.nextInt();
        int[][] matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        boolean[] output = new boolean[N];
        for (int i = 0; i < N; i++) {
            output[i] = true;
        }

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if(row != col) {
                    if(matrix[row][col] + matrix[col][row] > 0){
                        output[row] = false;
                        break;
                    }
                }
            }
        }

        boolean found = true;
        for (int i = 0; i < N; i++) {
            if(output[i]){
                System.out.print(i + " ");
                found = false;
            }
        }
        if(found){
            System.out.println("Graph doesn't contain isolated subgraph");
        }
    }
}
