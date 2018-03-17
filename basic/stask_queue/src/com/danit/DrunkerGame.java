package com.danit;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DrunkerGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Queue<Integer> player1 = new LinkedList<>();
        Queue<Integer> player2 = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            if (i > 4) {
                player2.add(in.nextInt());
            } else {
                player1.add(in.nextInt());
            }
        }

        int counter = 0;
        while (!player1.isEmpty() && !player2.isEmpty()) {
            int first = player1.poll();
            int second = player2.poll();

            if (first > second) {
                player1.add(first);
                player1.add(second);
            }else{
                player2.add(second);
                player2.add(first);
            }
                counter++;

        }
        System.out.println("Count of rounds: " + counter);
        System.out.println("Winner is player " + (player1.isEmpty() ? "2" : "1"));

    }

}

