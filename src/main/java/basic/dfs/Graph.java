package basic.dfs;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    public List<Integer>[] edges;
    int V;
    int E;

    public Graph(int V){
        this.V = V;
        this.E = 0;
        edges = new List[V];
        for(int i = 0; i < V; i++){
            edges[i] = new ArrayList<>();
        }
    }

    public void add(int v, int u){
        if (!edges[v].contains(u)) {
            edges[v].add(u);
            E++;
        }
    }

    public Iterable<Integer> adj(int v){
        return edges[v];
    }
}
