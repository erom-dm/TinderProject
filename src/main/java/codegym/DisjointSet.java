package codegym;

public class DisjointSet {
    public int[] joints;

    DisjointSet(int N) {
        joints = new int[N];
        //basic initialisation
        clear();
    }

    public void clear() {
        for (int i = 0; i < joints.length; i++) {
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