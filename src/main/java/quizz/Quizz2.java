package quizz;

import java.util.PriorityQueue;
import java.util.Queue;

public class Quizz2 {
    public static void main(String[] args) {
        int[] numbers = {78,80,51,1,15,23,72,72,77,42,29,87,33,58,75,92,22,92,43};
        Queue<Integer> myQueue = new PriorityQueue<>();
        int index = 0;
        while(index < numbers.length) {
            myQueue.add(numbers[index]);
            index++;
        }
        System.out.println(myQueue);
        while (!myQueue.isEmpty()) {
            System.out.print(myQueue.poll()+", ");
        }
        System.out.println();
    }
}
