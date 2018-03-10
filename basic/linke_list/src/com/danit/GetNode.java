package com.danit;

import java.util.*;

public class GetNode {

    static class LinkedNode {
        int val;
        LinkedNode next;

        public LinkedNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LinkedNode head = readList(in);
        System.out.print(get(head, in.nextInt()));
    }

    private static LinkedNode readList(Scanner in) {
        LinkedNode head = new LinkedNode(in.nextInt());
        LinkedNode temp = head;
        while (in.hasNext()){
            temp.next = new LinkedNode(in.nextInt());
            temp = temp.next;
        }
    return head;
    }

    public static Integer get(LinkedNode head, int k) {
      while (k > 0){
        head = head.next;
        if (head == null){
          return null;
        }
          k--;
      }
     return head.val;
    }
}
