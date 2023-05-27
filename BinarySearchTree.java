import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {}

    public BinarySearchTree(Node root) {
        this.setRoot(root);
    }
    //a
    public int getNumberOfNudes(Node node) {
       if (node == null) return 0;
       return 1 + getNumberOfNudes(node.getLeft()) + getNumberOfNudes(node.getRight());
    }
    public int numberOfNodes() {
        return getNumberOfNudes(getRoot());
    }
    //b
    public int getHeightOfTree(Node node) {
        if(node == null) return 0;
        int l = getHeightOfTree(node.getLeft());
        int r = getHeightOfTree(node.getRight());
        return Math.max(l, r) + 1;
    }
    //c
    public boolean isBST(Node node, int minKey, int maxKey) {
        if (node == null) {
            return true;
        }

        if (node.getKey() <= minKey || node.getKey() >= maxKey) {
            return false;
        }

        return isBST(node.getLeft(), minKey, node.getKey()) &&
                isBST(node.getRight(), node.getKey(), maxKey);
    }
    //d
    public Node searchByKey(Node node, int key) {
        if (node == null || node.getKey() == key) {
            return node;
        }
        if (node.getKey() < key) return searchByKey(node.getRight(), key);
        return searchByKey(node.getLeft(), key);
    }
    //e
    public Node getMax(Node node) {
        while (node.getRight() != null) node = node.getRight();
        return node;
    }
    //f
    public Node getMin(Node node) {
        while (node.getLeft() != null) node = node.getLeft();
        return node;
    }

    //h
    public void delete(int key) {
        root = deleteNode(root, key);
    }

    private Node deleteNode(Node node, int key) {
        if (node == null)
            return null;

        if (key < node.getKey()) {
            node.setLeft(deleteNode(node.getLeft(), key));
        } else if (key > node.getKey()) {
            node.setRight(deleteNode(node.getRight(), key));
        } else {

            if (node.getLeft() == null)
                return node.getRight();
            else if (node.getRight() == null)
                return node.getLeft();

            Node successor = getMin(node.getRight());

            node.setKey(successor.getKey());

            node.setRight(deleteNode(node.getRight(), successor.getKey()));
        }

        return node;
    }
    //i
    public void insert(int key) {
        root = insertNode(root, key);
    }
    private Node insertNode(Node node, int key) {
        if (node == null)
            return new Node(key);

        if (key < node.getKey())
            node.setLeft(insertNode(node.getLeft(), key));
        else if (key > node.getKey())
            node.setRight(insertNode(node.getRight(), key));

        return node;
    }

    //j
    public void readFriFile(String path) {
        try (Scanner scanner = new Scanner(new File(path))){
            int n = scanner.nextInt();
            Node[] nodes = new Node[n];
            for (int i = 0; i < n; i++) {
                nodes[i] = new Node(n);
            }
            for (int i = 0; i < n; i++) {
                nodes[i].setKey(scanner.nextInt());
                int left = scanner.nextInt();
                int right = scanner.nextInt();
                if (left != 0) {
                    nodes[i].setLeft(nodes[left - 1]);
                    nodes[left - 1].setParent(nodes[i]);
                }
                if (right != 0) {
                    nodes[i].setRight(nodes[right - 1]);
                    nodes[right - 1].setParent(nodes[i]);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("files has not been found");
        }
    }
    private Node deleteNodeWithKey(Node node, int key) {
        if (node == null)
            return null;

        if (key < node.getKey()) {
            node.setLeft(deleteNodeWithKey(node.getLeft(), key));
        } else if (key > node.getKey()) {
            node.setRight(deleteNodeWithKey(node.getRight(), key));
        } else {
            if (node.getLeft() == null)
                return node.getRight();
            else if (node.getRight() == null)
                return node.getLeft();

            Node successor = getMin(node.getRight());

            node.setKey(successor.getKey());

            node.setRight(deleteNodeWithKey(node.getRight(), successor.getKey()));
        }

        return node;
    }
    public void deleteNodesWithKeys(int[] keys) {
        for (int key : keys) {
            deleteNodeWithKey(root, key);
            System.out.println("Number of left vertices after deleting a key: " + key + ": " + numberOfNodes());
        }
    }
    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }


}
