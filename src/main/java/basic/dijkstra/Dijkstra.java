package basic.dijkstra;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class Dijkstra {

    final static String[] cities = {"Київ","Одеса","Вінниця","Львів","Тернопіль","Харків","Миколаїв","Запоріжжя"};
                                  //  0       1        2        3         4         5         6           7

    final static int[][] dists = {
            {   0,  -1, 266,  -1,  -1, 487,  -1, 568}, // 0
            {  -1,   0,  -1,  -1,  -1,  -1, 134, 487}, // 1
            { 266,  -1,   0, 369, 239,  -1,  -1,  -1}, // 2
            {  -1,  -1, 369,   0, 127,  -1,  -1,  -1}, // 3
            {  -1,  -1, 239, 127,   0,  -1,  -1,  -1}, // 4
            { 487,  -1,  -1,  -1,  -1,   0, 551, 303}, // 5
            {  -1, 134,  -1,  -1,  -1, 551,   0, 352}, // 6
            { 568, 487,  -1,  -1,  -1, 303, 352,   0}, // 7
            //0  //1  //2  //3  //4  //5  //6  //7
    };

    public static List<Integer> neighbourCities(int city){
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < cities.length; i++) {
            if (dists[city][i] > 0){
                result.add(i);
            }
        }
        return result;
    }

    public static void relax(PriorityQueue<Integer> queue, int[] distTo, int[] edgeTo){
        int current = queue.poll();
        for (int city : neighbourCities(current)) {
            if (distTo[current] + dists[city][current] < distTo[city]){
                queue.remove(city);
                distTo[city] = distTo[current] + dists[city][current];
                edgeTo[city] = current; //saving parent
                queue.add(city);
            }
        }
    }

    public static void main(String[] args) {

        int from = 2;
        int to = 7;
        int[]edgeTo = new int[cities.length];
        int[]distTo = new int[cities.length];

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> distTo[o1] - distTo[o2]);
        for (int i = 0; i < cities.length; i++) {
            distTo[i] = i == from ? 0 : Integer.MAX_VALUE;
            edgeTo[i] = i == from ? from : -1;
            queue.add(i);
        }

        while (!queue.isEmpty()){
            relax(queue, distTo, edgeTo);
        }

        System.out.printf("Distanse from %s to %s : %d \n", cities[from], cities[to], distTo[to]);

        System.out.printf("Path from %s to %s : \n", cities[from], cities[to]);

        Stack<Integer> stack = new Stack<>();
        stack.add(to);
        while(edgeTo[stack.peek()] != from){
            stack.add(edgeTo[stack.peek()]);
        }
        stack.add(from);
        while(!stack.isEmpty()){
            System.out.print(cities[stack.pop()] + " ");
        }

    }


}
