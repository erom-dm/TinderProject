package com.danit;

import java.util.Scanner;

public class Test {

    public static class Node {
        public Node next;
        public int val;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{ 1, 2, 3, 4, 5};

        Node head = new Node(-1);
        Node temp = head;

        for (int i : array) {
            temp.next = new Node(i);
            temp = temp.next;
        }

        head = head.next;

        print(head);
        head = swap(head);
        print(head);
    }

    public static Node swap(Node head) {
        Node node = head;
        head = new Node(-1);
        head.next = node;
        node = head;

        while (node != null && node.next != null && node.next.next != null) {
            Node temp1 = node.next;
            Node temp2 = node.next.next.next;

            node.next = node.next.next;
            node.next.next = temp1;
            temp1.next = temp2;

            node = temp1;
        }

        return head.next;
    }

    private static void print(Node head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }

        System.out.println();
    }
}