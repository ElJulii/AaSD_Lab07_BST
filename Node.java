public class Node {
    private int key;
    private Node right;
    private Node left;
    private Node parent;


    public Node(int key){}

    public Node(int key, Node left, Node right) {
        this.setKey(key);
        this.setLeft(left);
        this.setRight(right);
        this.setParent(parent);}

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
}
