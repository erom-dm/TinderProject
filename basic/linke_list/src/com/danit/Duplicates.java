package com.danit;

import java.util.*;

public class Duplicates {

    public static class Node {
        Node next = null;
        int value;

        public Node (int value) {
            this.value = value;
        }
    }
    public static Node removeDuplicates(Node head){

        Node temp = head;
        while (temp != null){

        while (temp.next != null && temp.value == temp.next.value){
          temp.next = temp.next.next;
        }
        temp = temp.next;
        }


        return head;
    }
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        Node head = new Node(0);
        Node node = head;

        for (int i = 0; i < N; i++) {
            node.next = new Node(in.nextInt());
            node = node.next;
        }

        Node result = removeDuplicates(head.next);

        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}