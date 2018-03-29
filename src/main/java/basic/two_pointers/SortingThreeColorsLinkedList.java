package basic.two_pointers;

import java.util.*;

public class SortingThreeColorsLinkedList {

    public static class Node {
        Node next = null;
        int value;

        public Node (int val) {
            value = val;
        }
    }

    public static Node sort(Node head){
        Node head0 = new Node(-1);
        Node head0Body = head0;
        Node head1 = new Node(-1);
        Node head1Body = head1;
        Node head2 = new Node(-1);
        Node head2Body = head2;

        while (head != null) {
            if (head.value == 0) {
                head0Body.next = head;
                head0Body = head0Body.next;
            }
            if (head.value == 1) {
                head1Body.next = head;
                head1Body = head1Body.next;
            }
            if (head.value == 2) {
                head2Body.next = head;
                head2Body = head2Body.next;
            }
            head = head.next;

        }
        head0Body.next = null;
        head1Body.next = null;
        head2Body.next = null;
        head = head0.next;


        if (head == null) {
            head = head1.next;
        } else {
            head0Body.next = head1.next;
        }
        if (head1.next == null) {
            head0Body.next = head2.next;
        } else {
            head1Body.next = head2.next;
        }

        return  head;
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Node head = new Node(in.nextInt());
        Node node = head;

        for(int i = 1; i < n; i++){
            node.next = new Node(in.nextInt());
            node = node.next;
        }

        Node result = sort(head);

        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}