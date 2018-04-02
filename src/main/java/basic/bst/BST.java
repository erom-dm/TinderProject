package basic.bst;

public class BST {
    class Node {
        private final int key;
        String value;
        Node left;
        Node right;

        Node(int key) {
            this(key, "");
        }

        Node(int key, String value) {
            this.key = key;
            this.value = value;
        }

        int key() {
            return this.key;
        }
    }

    private Node root;
    private String found;

    public void add(int key, String value) {
        found = value; // please !!!! don't do like this ......
        root = addRecursive(key, root);
    }

    public void add(int key) {
        root = addRecursive(key, root);
    }

    private Node addRecursive(int key, Node current) {
        if (current == null) {
            return new Node(key, found); // please !!!! don't do like this ......
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

    public String get(int key) {
        return containsRecursive(key, root) ? found : null;
    }

    private boolean containsRecursive(int key, Node current) {
        if (current == null) {
            return false;
        }
        if (current.key()==key) {
            found=current.value;
            return true;
        }
        if (key < current.key()) {
            return containsRecursive(key, current.left);
        } else { // key > current.key()
            return containsRecursive(key, current.right);
        }
    }

    public void remove(int key) {
        root = removeRecursive(key, root);
    }

    private Node removeRecursive(int key, Node current) {
        if (current == null) {
            // end of the branch
            return null;
        }
        if (key > current.key()) {
            // traverse right
            current.right = removeRecursive(key, current.right);
        } else if (key < current.key()) {
            // traverse left
            current.left = removeRecursive(key, current.left);
        } else { // key < current.key(). we found Node
            if (current.left == null) {
                // if only right branch exists
                return current.right;
            }
            if (current.right == null) {
                // if only left branch exists
                return current.left;
            }
            // if two branches exist
            Node temp = current;
            current = min(temp.right);
            current.right = deleteMin(temp.right);
            current.left = temp.left;
        }
        return current;
    }

    private Node min(Node current) {
        if (current.left == null) {
            return current;
        } else {
            return min(current.left);
        }
    }

    private Node deleteMin(Node current) {
        if (current.left == null) {
            return current.right;
        } else {
            current.left = deleteMin(current.left);
            return current;
        }
    }

}
