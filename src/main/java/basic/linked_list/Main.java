package basic.linked_list;

public class Main {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node (2);
        head.next.next = new Node(3);

        removeNext(head);
    }

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void removeNext(Node head) {
        head.next = head.next.next;
    }

}
