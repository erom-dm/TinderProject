package basic.linked_list;

import java.util.*;

public class CycleInList {

    public static class Node {
        Node next = null;
        int value;

        public Node(int val) {
            value = val;
        }
    }
    public static void isCycle(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null){
            slow = slow.next;
            if(fast.next == null){
                break;
            }
            fast = fast.next.next;
            if (fast == slow){
                System.out.println("contains");
                return;
            }
        }
        System.out.println("doesn't contain");
    }


    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int[] nums = new int[in.nextInt()];

        for(int i = 0; i < nums.length; i++){
            nums[i] = in.nextInt();
        }

        isCycle(arrayToLinkedList(nums));
    }

    public static Node arrayToLinkedList(int[] nums){
        Node[] nodes = new Node[nums.length];
        Node node = new Node(nums[0]);
        nodes[0] = node;

        while(node.value < nums.length){

            if(nodes[node.value] != null){
                node.next = nodes[node.value];
                break;
            }

            node.next = new Node(nums[node.value]);
            nodes[node.value] = node.next;
            node = node.next;
        }

        return nodes[0];
    }
}