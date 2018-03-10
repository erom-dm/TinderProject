package com.danit;

import java.util.*;

public class MergeSort {

    public static class Node{
        Node next = null;
        int value;

        public Node(int val) {
            value = val;
        }
    }

    public static Node sort(Node head){
        if (head.next == null) return head;
        Node temp = head;
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }

        Node leftHead = new Node(-1);
        Node rightHead = new Node(-1);

        Node left = leftHead;
        Node right = rightHead;

        temp = head;
        for (int i = 0; i < count; i++) {
            if (i < count / 2) {
                left.next = new Node(temp.value);
                left = left.next;
            } else {
                right.next = new Node(temp.value);
                right = right.next;
            }

            temp = temp.next;
        }

        leftHead = sort(leftHead.next);
        rightHead = sort(rightHead.next);

        return solve(leftHead, rightHead);
    }

    public static Node solve(Node first, Node second){
        Node out = new Node(-1);
        Node tail = out;

        while (first != null && second != null){
            if (first.value > second.value){
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
        int n = in.nextInt();
        Node head = new Node(-1);
        Node node = head;

        for (int i = 0; i < n; i++) {
            node.next = new Node(in.nextInt());
            node = node.next;
        }

        printList(head.next);

        Node result = sort(head.next);

        printList(result);
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }

        System.out.println();
    }
}