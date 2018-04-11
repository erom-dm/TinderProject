package codegym;

import java.util.*;

public class Euler {
    public static UndirectedGraph readGraph(Scanner in){
        int V = in.nextInt(), E = in.nextInt();
        UndirectedGraph graph = new UndirectedGraph(V);
        for(int i = 0; i < E; i++){
            graph.add(in.nextInt(), in.nextInt());
        }
        return graph;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        UndirectedGraph graph = readGraph(in);
        int odd = 0;
        for (int i = 0; i < graph.V(); i++) {
            int size = 0;
            for (int j : graph.adj(i) ) {
               if (i != j) {
                   size++;
               }
            }
            if (size % 2 != 0){
                odd++;
            }
        }

        if (odd == 0){
            System.out.println("Eulerian");
        } else if (odd == 2){
            System.out.println("Semi-Eulerian");
        } else {
            System.out.println("not Eulerian");
        }
    }

    public static class UndirectedGraph {

        private int E,V;
        Set<Integer>[] adjacent;

        UndirectedGraph(int V){
            this.V = V;
            adjacent = new Set[V];
            for(int i = 0; i < adjacent.length; i++){
                adjacent[i] = new HashSet<Integer>();
            }
        }

        public int V(){
            return V;
        }

        public int E(){
            return E;
        }

        public void add(int u, int v){
            validate(u);
            validate(v);

            if(!adjacent[u].contains(v)){
                E++;
                adjacent[u].add(v);
                adjacent[v].add(u);

            }
        }

        public Integer[] adj(int v){
            validate(v);
            Integer[] vertices = new Integer[adjacent[v].size()];
            return adjacent[v].toArray(vertices);
        }

        private void validate(int v){
            if(v >= V || v < 0) throw new IllegalArgumentException();
        }
    }
}
