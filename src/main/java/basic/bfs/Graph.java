package basic.bfs;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private List<Integer>[] edges;
    private int V;
    private int E;

    public Graph(int V){
        this.V = V;
        this.E = 0;
        edges = new List[V];
        for(int i = 0; i < V; i++){
            edges[i] = new ArrayList<>();
        }
    }

    public int V(){
        return this.V;
    }

    public int E(){
        return this.E;
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
