package com.danit;

import java.util.*;

public class MergeLists  {

    public static class Node {
        Node next = null;
        int val;

        public Node (int val) {
            this.val = val;
        }
    }
    public static Node solve(Node first, Node second){
        Node out = new Node(-1);
        Node tail = out;

        while (first != null && second != null){
            if (first.val > second.val){
                tail.next = second;
                second = second.next;
            }
            else{
                tail.next = first;
                first = first.next;
            }
            tail = tail.next;
        }

        if(first != null){
            tail.next = first;
        }
        else{
            tail.next = second;
        }

        return out.next;


    }
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        printList(solve(readList(in), readList(in)));
    }

    public static Node readList(Scanner in) {
        int N = in.nextInt();
        Node head = new Node(-1);
        Node node = head;

        for (int i = 0; i < N; i++) {
            node.next = new Node(in.nextInt());
            node = node.next;
        }

        return head.next;
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
