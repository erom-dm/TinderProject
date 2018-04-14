package basic.dijkstra;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class Dijkstra {

    public static class CityInfo{
        public int cityIndex;
        public int distTo;
        public int fromCity;

        public CityInfo(int cityIndex, int distTo, int fromCity){
            this.cityIndex = cityIndex;
            this.distTo = distTo;
            this.fromCity = fromCity;
        }

        public String cityName(){
            return cities[cityIndex];
        }
    }

    final static String[] cities = {"Київ","Одеса","Вінниця","Львів","Тернопіль","Харків","Миколаїв","Запоріжжя"};
                                  //  0       1        2        3         4         5         6           7

    final static int[][] dists = {
            {   0,  -1, -1,  -1,  -1, -1,  -1, -1}, // 0
            {  -1,   0,  -1,  -1,  -1,  -1, 134, 487}, // 1
            { -1,  -1,   0, 369, 239,  -1,  -1,  -1}, // 2
            {  -1,  -1, 369,   0, 127,  -1,  -1,  -1}, // 3
            {  -1,  -1, 239, 127,   0,  -1,  -1,  -1}, // 4
            { -1,  -1,  -1,  -1,  -1,   0, 551, 303}, // 5
            {  -1, 134,  -1,  -1,  -1, 551,   0, 352}, // 6
            { -1, 487,  -1,  -1,  -1, 303, 352,   0}, // 7
            //0  //1  //2  //3  //4  //5  //6  //7
    };

    static CityInfo[] cityInfos = new CityInfo[cities.length];

    public static List<Integer> neighbourCities(int city){
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < cities.length; i++) {
            if (dists[city][i] > 0){
                result.add(i);
            }
        }
        return result;
    }

    public static void relax(PriorityQueue<CityInfo> queue){
        CityInfo current = queue.poll();

        if(current.distTo == Integer.MAX_VALUE) return;

        for (int city : neighbourCities(current.cityIndex)) {
            if (current.distTo + dists[city][current.cityIndex] < cityInfos[city].distTo){
                queue.remove(city);
                cityInfos[city].distTo = current.distTo + dists[city][current.cityIndex];
                cityInfos[city].fromCity = current.cityIndex; //saving parent
                queue.add(cityInfos[city]);
            }
        }
    }

    static int getCityIndex(String city){
        for (int i = 0; i < cities.length; i++) {
            if(cities[i].equals(city)) return i;
        }
        return -1;
    }

    public static void main(String[] args) {

        if(args.length < 2){
            System.out.println("Set from and to cities");
            return;
        }

        String cityFrom  = args[0];
        String cityTo  = args[1];

        int from  = getCityIndex(cityFrom);
        int to  =   getCityIndex(cityTo);

        if(from  == - 1 || to == -1) {
            System.out.println("Wrong cites name");
            return;
        }

        PriorityQueue<CityInfo> queue = new PriorityQueue<>((o1, o2) -> o1.distTo - o2.distTo);
        for (int i = 0; i < cities.length; i++) {
            CityInfo cityInfo;
            if(i == from) {
                cityInfo  = new CityInfo(i,0, from);
            } else {
                cityInfo  = new CityInfo(i,Integer.MAX_VALUE, -1);
            }
            queue.add(cityInfo);
            cityInfos[i] = cityInfo;
        }

        while (!queue.isEmpty()) {
            relax(queue);
        }

        if(cityInfos[to].fromCity == -1){
            System.out.println("Cities aren't connected");
            return;
        }

        System.out.printf("Distanse from %s to %s : %d \n", cityFrom, cityTo, cityInfos[to].distTo);

        System.out.printf("Path from %s to %s : \n", cityFrom, cityTo);

        Stack<CityInfo> stack = new Stack<>();
        stack.add(cityInfos[to]);
        while(stack.peek().fromCity != from){
            stack.add(cityInfos[stack.peek().fromCity]);
        }
        stack.add(cityInfos[from]);
        while(!stack.isEmpty()){
            System.out.print(cities[stack.pop().cityIndex] + " ");
        }
    }


}
