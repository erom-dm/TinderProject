package basic.bfs;

import basic.dfs.Graph;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CityPath_BFS {

    public static final String[] cities = {
            "Київ", "Житомир", "Лубни", "Бориспіль", "Фастів", "Ніжин", "Умань", "Суми", "Хмельницький", "Миколаїв"};
    // 0       1          2        3            4         5         6        7       8              9


//    public static final int[][] roads = {
///* 0 Київ  */    {1, 5, 7, 8, 9}, // індекси міст з якими сполучений Київ
///* 1 Житомир */  {0, 2, 8}, // міста з'днані з Житомиром
///* 2 Лубни */    {4, 9},
///* 3 Бориспіль */{2, 5},
///* 4 Фастів */   {9},
///* 5 Ніжин */    {0, 3},
///* 6 Умань */    {8, 9},
///* 7 Суми */     {0, 2, 6},
///* 8 Хмельн. */  {6},
///* 9 Миколаїв */  {2, 6},
//    };


    public static void main2() {
        File f = new File("1");
        try {
            FileInputStream fis = new FileInputStream(f);
        } catch (FileNotFoundException e) {
            System.out.println("something wrong...");
            //e.printStackTrace();
        }
    }

    public static void main3() throws FileNotFoundException {
        File f = new File("1");
        FileInputStream fis = new FileInputStream(f);
    }

    public static void main(String[] args)  {
        //main2();

        Graph roads = new Graph(cities.length);

        roads.add(0, 1);
        roads.add(0, 5);
        roads.add(0, 7);
        roads.add(0, 8);
        roads.add(0, 9);
        roads.add(1, 0);
        roads.add(1, 2);
        roads.add(1, 8);
        roads.add(2, 4);
        roads.add(2, 9);
        roads.add(3, 2);
        roads.add(3, 5);
        roads.add(4, 9);
        roads.add(5, 0);
        roads.add(5, 3);
        roads.add(6, 8);
        roads.add(6, 9);
        roads.add(7, 0);
        roads.add(7, 2);
        roads.add(7, 6);
        roads.add(8, 6);
        roads.add(9, 2);
        roads.add(9, 6);

        int start = 8;
        int end = 0;
        boolean[] visited = new boolean[cities.length];
        Queue<Integer> q = new LinkedList<>();
        int[] parents = new int[cities.length];

        q.add(start);
        visited[start] = true;

        // BFS
        while (!q.isEmpty()) {
            int current = q.poll();
            for (int city: roads.adj(current)) {
                if (!visited[city]) {
                    q.add(city);
                    visited[city] = true;
                    parents[city] = current;
                }
            }
        }

        System.out.printf("From %s we can reach: ", cities[start]);
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] && i != start) {
                System.out.print(cities[i] + " ");
            }

        }

        System.out.printf(isConected(roads,start, end)?
                        "\nPath from %s to %s exists" : "\nPath from %s to %s doesn't exist",
                cities[start],
                cities[end]);

        if (visited[end]) {
            Stack<Integer> path = new Stack<>();
            path.push(end);

            while (path.peek() != start) {
                path.push(parents[path.peek()]);
            }
            System.out.printf("\nPath was: ");
            while (!path.isEmpty()) {
                System.out.print(cities[path.pop()] + " ");
            }

        } else {
            System.out.println("\nPath did not found!");
        }
    }

    public static void dfs(basic.dfs.Graph G, int current, boolean[] visited, int[] parents) {
        for (int vertex : G.adj(current)) {
            if (!visited[vertex]) {
                visited[vertex] = true;
                parents[vertex] = current;
                dfs(G, vertex, visited, parents);
            }
        }
    }

    public static boolean isConected(basic.dfs.Graph G, int start, int end){
        return isConected(G, start, end, new boolean[G.V()]);
    }

    public static boolean isConected(Graph G, int current, int end, boolean[] visited) {
        if (current == end) {
            return true;
        }

        for (int vertex : G.adj(current)) {
            if (!visited[vertex]) {
                visited[vertex] = true;
                if(isConected(G, vertex, end, visited)){
                    return true;
                }
            }
        }
        return false;
    }

}