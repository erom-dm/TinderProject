package basic.dfs;

import java.util.Stack;

public class CityPaths {

    public static final String[] cities = {
            "Київ", "Житомир", "Лубни", "Бориспіль", "Фастів", "Ніжин", "Умань", "Суми", "Хмельницький", "Миколаїв"};
          // 0       1          2        3            4         5         6        7       8              9


    public static final int[][] roads = {
/* 0 Київ  */    {1, 5, 7, 8, 9}, // індекси міст з якими сполучений Київ
/* 1 Житомир */  {0, 2, 8}, // міста з'днані з Житомиром
/* 2 Лубни */    {4, 9},
/* 3 Бориспіль */{2, 5},
/* 4 Фастів */   {9},
/* 5 Ніжин */    {0, 3},
/* 6 Умань */    {8, 9},
/* 7 Суми */     {0, 2, 6},
/* 8 Хмельн. */  {6},
/* 9 Миколаїв */  {2, 6},
    };


    public static void main(String[] args) {

        int start = 8;
        int end = 0;
        boolean[] visited = new boolean[roads.length];
        Stack<Integer> stack = new Stack<>();
        int[] parents = new int[roads.length];

        stack.push(start);
        visited[start] = true;

        while (!stack.isEmpty()) {
            int current = stack.pop();
            for (int city: roads[current]) {
                if (!visited[city]) {
                    stack.push(city);
                    visited[city] = true;
                    parents[city] = current;
                }
            }
        }
        System.out.printf("From %s we can reach: ", cities[start]);
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] && i != start) {
                System.out.print(cities[i]+" ");
            }

        }
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

}