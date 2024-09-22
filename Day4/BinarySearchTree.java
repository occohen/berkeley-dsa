public class BinarySearchTree {
    //node constructor, class
    class Node {
        int key;
        Node left, right;
        public Node(int key) {
            this.key = key;
            left = null;
            right = null;
        }
    }

    //binary search tree constructor
    Node root;
    BinarySearchTree() {
        root = null;
    }

    //method for insert on bst
    void insert(int key) {
        root = insertRec(root, key);
    }

    //node insertrec recursive method
    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        //if smaller, go left if bigger, go right
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    //get the minimum
    int findMin() {
        //edge case, empty tree
        if (root == null) {
            throw new RuntimeException("The tree is empty");
        }
        Node current = root;
        //get leftmost node, return
        while (current.left != null) {
            current = current.left;
        }
        return current.key;
    }

    //same as min but go to the right
    int findMax() {
        if (root == null) {
            throw new RuntimeException("The tree is empty");
        }
        Node current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.key;
    }
    
    int sumOfValues() {
        return sumOfValuesRec(root);
    }
    //recursive, add all the values by going down every path
    int sumOfValuesRec(Node root) {
        if (root == null)
            return 0;
        return root.key + sumOfValuesRec(root.left) + sumOfValuesRec(root.right);
    }

    //check if it is a bst. use absolute min and absolute max as a starter range
    boolean isBST() {
        return isBSTRec(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    //recursive, all following subtrees must also be bsts
    boolean isBSTRec(Node node, int min, int max) {
        if (node == null){
            return true;
        }//if it never returns false and you reach the end, then it is true
        if (node.key < min || node.key > max){
    
            return false;
        }//if either is not right (if it is less than the min range or greater than the max range then return false)

        //recursive call, move both left and right until all subtrees are covered
        return isBSTRec(node.left, min, node.key - 1) && isBSTRec(node.right, node.key + 1, max);
    }



    //test it out
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(10);
        bst.insert(20);
        bst.insert(30);
        bst.insert(40);
        bst.insert(50);
        bst.insert(60);
        bst.insert(70);

        System.out.println("Minimum value: " + bst.findMin());
        System.out.println("Maximum value: " + bst.findMax());
        System.out.println("Sum of all values: " + bst.sumOfValues());

        BinarySearchTree notBST = new BinarySearchTree();
        Node a = notBST.new Node(2);
        Node b = notBST.new Node(1);
        Node c = notBST.new Node(5);
        Node d = notBST.new Node(2); // this makes it return false. if it was greater than 5, it would still be true
        notBST.root = a;
        notBST.root.left = b;
        notBST.root.right = c;
        notBST.root.right.right = d;



        //check if it is a bst
        System.out.println(bst.isBST());
        //should return true

        System.out.println(notBST.isBST());
        //should return false
    }
}
