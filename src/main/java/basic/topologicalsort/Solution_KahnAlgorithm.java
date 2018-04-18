package basic.topologicalsort;
import java.util.*;
import java.util.stream.Collectors;

public class Solution_KahnAlgorithm {

    private static String intToStr(Integer n) {
        return Integer.toString(n);
    }

    public static class Graph {
        int E,V;
        Set<Integer>[] adjacent;

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

    public static Graph readGraph(Scanner in){
        int V = in.nextInt();
        int E = in.nextInt();
        Graph graph = new Graph(V);
        for(int i = 0; i < E; i++){
            graph.add(in.nextInt(), in.nextInt());
        }
        return graph;
    }

    public static void main(String[] args) {
        String input = "4 6\n" +
                "0 2\n" +
                "0 3\n" +
                "0 1\n" +
                "1 3\n" +
                "1 2\n" +
                "3 2";

        Scanner in = new Scanner(input);
        Graph graph = readGraph(in);
        System.out.println(topologicalSort(graph));;
    }

    private static boolean hasNoIncoming(Graph graph, Integer nodeM) {
        for (int i = 0; i < graph.V(); i++) {
            for (int edj : graph.adj(i)) {
                if (edj == nodeM) return false;
            }
        }
        return true;
    }

    private static void removeEdge(Graph graph, Integer nodeN, Integer nodeM) {
        //for (int node : graph.adj(nodeN) ){
        //    if (node == nodeM) {
                graph.adjacent[nodeN].remove(nodeM);
                graph.E--;
        //    }
        //}
    }

    private static Set<Integer> findStarts(Graph graph) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < graph.V() ; i++) {
            if (hasNoIncoming(graph, i)) {
                set.add(i);
            }
        }
        return set;
    }

    private static boolean graphHasEdges(Graph graph) {
        return graph.E()>0;
    }

    public static String topologicalSort(Graph graph) {
        // Empty list that will contain the sorted elements
        List<Integer> L = new ArrayList<>();
        Set<Integer> S = findStarts(graph);
        while (!S.isEmpty()) {
            for (Integer nodeN : S) {
                S.remove(nodeN);
                L.add(nodeN);
                Integer[] nodesFromN = graph.adj(nodeN);
                for (Integer nodeM : nodesFromN) {
                    removeEdge(graph, nodeN, nodeM);
                    if (hasNoIncoming(graph, nodeM)) {
                        S.add(nodeM);
                    }
                }
            }
        }
        if (graphHasEdges(graph)) {
            return "graph has at least one cycle";
        } else {
            return L.stream().map(Solution_KahnAlgorithm::intToStr).collect(Collectors.joining(" "));
        }
    }

}