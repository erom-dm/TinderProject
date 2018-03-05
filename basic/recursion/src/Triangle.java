import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] tri = new int[n][n];

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < i+1; j++) {
                tri[i][j] = in.nextInt();
            }
        }
        System.out.println(path(tri, 0,0, 0));
    }

    public static int path (int tri[][], int h, int w, int sum) {
        if (h == tri.length) {
            return sum;
        }

        int left = path(tri, h+1, w+1, sum + tri[h][w]);
        int right = path(tri, h+1,  w, sum + tri[h][w]);

        if (left < right) {
            return left;
        }

        return right;
    }
}
