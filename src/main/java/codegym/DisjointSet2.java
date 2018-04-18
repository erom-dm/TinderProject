package codegym;

public class DisjointSet2 {
    private int[] joints;

    DisjointSet2(int N) {
        joints = new int[N];
        clear();
    }

    public void clear() {
        for (int i = 0; i < joints.length; i++) {
            joints[i] = i;
        }
    }

    public void union(int i, int j){
        int root = Math.min(root(i),root(j));
        joints[root(i)] = root;
        joints[root(j)] = root;
    }

    public boolean find(int i, int j){
        return (root(i) == root(j));
    }

    public int root(int k) {
        while( k != joints[k]) {
            k = joints[k];
        }
        return k;
    }
}
