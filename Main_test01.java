public class Main_test01 {
    public static void main(String[] args) {

        Node f = new Node(1, null, null);
        Node g = new Node(4, null, null);
        Node h = new Node(7, null, null);
        Node i = new Node(13, null, null);

        Node d = new Node(14, i, null);
        Node e = new Node(6, g, h);
        Node c = new Node(10, null, d);
        Node b = new Node(3, f, e);
        Node a = new Node(8, b, c);

        BinarySearchTree tree = new BinarySearchTree(a);
        System.out.println("Количество вершим в поддереве " + tree.getNumberOfNudes(c));
        System.out.println("Все " + tree.numberOfNodes());
        System.out.println("Высота = " + tree.getHeightOfTree(a));
        System.out.println("Это дерево поиска: " + tree.isBST(a, Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println("Поиск значения: " + tree.searchByKey(a, 2));
        System.out.println("Min = " + tree.getMin(a));
        System.out.println("Max = " + tree.getMax(a));
        tree.delete(1);
        System.out.println("We insert a new key F");
        System.out.println(tree.getNumberOfNudes(f));

        BinarySearchTree treeFromFile = new BinarySearchTree();
        treeFromFile.readFriFile("\\src\\input.txt");
        System.out.println("Amount = " + treeFromFile.numberOfNodes());
        int depth = treeFromFile.getHeightOfTree(treeFromFile.getRoot());
        System.out.println("Height of the tree: " + depth);
        System.out.println("it It bts? = " + treeFromFile.isBST(treeFromFile.getRoot(), 1, 10));
        BinarySearchTree treeFromFile2 = new BinarySearchTree();

        treeFromFile2.readFriFile("src\\input_2.txt");
        int[] keysToDelete = {4, 6, 3};
        treeFromFile2.deleteNodesWithKeys(keysToDelete);

        /*
*       b.setParent(a);
        c.setParent(a);
        d.setParent(c);
        e.setParent(b);
        f.setParent(b);
        g.setParent(e);
        h.setParent(e);
        i.setParent(d);
         */
    }
}
