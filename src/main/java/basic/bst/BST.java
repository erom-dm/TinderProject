package basic.bst;

public class BST {
    class Node {
        private final int key;
        Node left;
        Node right;

        Node(int key) {
            this.key = key;
            //System.out.printf("Node with key %d created\n", this.key);
        }

        int key() {
            return this.key;
        }

    }
    private Node root;

    public void add(int key) {
        root=addRecursive(key, root);
    }

    private Node addRecursive(int key, Node current) {
        if (current == null) {
            return new Node(key);
        }
        if (key > current.key()) {
            current.right = addRecursive(key, current.right);
        } else { // key < current.key()
            current.left = addRecursive(key, current.left);
        }
        return current;
    }

    public boolean contains(int key) {
        return containsRecursive(key, root);
    }

    private boolean containsRecursive(int key, Node current) {
        if (current == null) {
            return false;
        }
        if (current.key()==key) {
            return true;
        }
        if (key < current.key()) {
            return containsRecursive(key, current.left);
        } else {
            return containsRecursive(key, current.right);
        }
    }
}
