package codegym;

public class DisjointSet {
    private int[] joints;

    DisjointSet(int N) {
        joints = new int[N];
        clear();
    }

    public void clear() {
        for (int i = 0; i < joints.length; i++) {
            joints[i] = i;
        }
    }

    public void union(int i, int j){
        int root = Math.min(joints[i], joints[j]);
        int tail = Math.max(joints[i], joints[j]);
        replace(root, tail);
    }

    public boolean find(int i, int j){
        return joints[i] == joints[j];
    }

    private void replace(int src, int dst) {
        for (int i = 0; i < joints.length; i++) {
            if(joints[i] == src){
                joints[i] = dst;
            }
        }
    }
}