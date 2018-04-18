package basic.topologicalsort;
import java.util.*;

public class Solution_KahnAlgorithm {

    public static class Graph {
        private int E,V;
        private Set<Integer>[] adjacent;

        Graph(int V){
            this.V = V;
            adjacent = new Set[V];
            for(int i = 0; i < adjacent.length; i++){
                adjacent[i] = new HashSet<Integer>();
            }
        }

        public int V(){ return V;}

        public int E(){ return E;}

        public void add(int u, int v){
            if(!adjacent[u].contains(v)){
                E++;
                adjacent[u].add(v);
            }
        }

        public Integer[] adj(int v){
            Integer[] vertices = new Integer[adjacent[v].size()];
            return adjacent[v].toArray(vertices);
        }

    }

    public static Graph readGraph(){
        Scanner in = new Scanner(System.in);
        int V = in.nextInt();
        int E = in.nextInt();
        Graph graph = new Graph(V);
        for(int i = 0; i < E; i++){
            graph.add(in.nextInt(), in.nextInt());
        }
        return graph;
    }

    public static void main(String[] args) {
        Graph graph =  readGraph();
        List<Integer> L = kahn(graph);
        for (int i = 0; i < L.size(); i++) {
            System.out.print(L.get(i)+" ");
        }
        System.out.println();
    }

    private static Set<Integer> findWithNoIncoming(Graph graph) {
        // TODO
        return null;
    }

    private static boolean mHasNoOtherIncomingEdges(int nodeM) {
        // TODO
        return false;
    }

    private static Set<Integer> getOutcgoingNodes(int node) {
        // TODO
        return null;
    }

    private static void removeEdgeFromGraph(int node, int nodeM) {
        // TODO
    }

    private static List<Integer> kahn(Graph graph) {
        List<Integer> L = new ArrayList<>();
        Set<Integer> S = findWithNoIncoming(graph);
        while (!S.isEmpty()) {
            for (int node : S) {
                S.remove(node);
                L.add(node);
                for (int nodeM : getOutcgoingNodes(node)) {
                    removeEdgeFromGraph(node, nodeM);
                    if (mHasNoOtherIncomingEdges(nodeM)) {
                        S.add(nodeM);
                    }
                }
            }
        }
        return L;
    }
}