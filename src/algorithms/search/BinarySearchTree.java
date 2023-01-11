package algorithms.search;

import java.util.Scanner;

/*Comparable is used here to impose an ordering on the objects of type Key.
 The compareTo() method is needed in order to compare two objects of type Key and determine which is greater
or lesser than the other.
 This is necessary in order to correctly construct a binary search tree, which stores keys in an ordered manner.*/
public class BinarySearchTree<Key extends Comparable<Key>,Value> {

    private Node root;

    /*The class is private because it is an internal part of the structure of the program.
    Making it private prevents other parts of the program from accessing the Node class directly and keeps the structure of the program secure.
    The constructor is public because it allows the Node class to be instantiated when it is needed.*/
    private class Node{
        private Node left,right;
        private Key key;
        private Value val;
        private int size;

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    /* * Inserts the specified key-value pair into the symbol table, overwriting the old
     * value with the new value if the symbol table already contains the specified key.
     * Deletes the specified key (and its associated value) from this symbol table
     * if the specified value is {@code null}.*/
    public void put(Key key, Value val){
        if(key == null) throw new IllegalArgumentException("calls put() with a null key");
        if(val == null){
            delete(key);
            return;
        }
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val){
        if(x == null) return new Node(key, val, 1);
        /*By using compareTo() method, we can compare the two keys in an efficient way. It is built in the Key type,
        which is Comparable in Java. The compareTo() method will return a negative integer, zero, or a positive integer
        as this object is less than, equal to, or greater than the specified object. This makes the code more readable and efficient.*/
        int cmp = key.compareTo(x.key);
        if(cmp < 0) x.left = put(x.left, key,val);
        else if(cmp > 0) x.right = put(x.right, key,val);
        else x.val = val;
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    //Removes the specified key and its associated value from this symbol table
    public void delete(Key key) {
        if(key == null) throw new IllegalArgumentException("calls delete() with a null key");
        root = delete(root, key);
    }

    /*
The code is a recursive function that deletes a given key from a binary search tree.
It starts by checking if the node (x) is null, and if it is, it returns null.
It then compares the given key (key) to the key of the node (x.key).
If the given key is less than the node's key, it calls the delete function on the left child of the node (x.left).
 If the given key is greater than the node's key, it calls the delete function on the right child of the node (x.right).
 If the keys are equal, it checks if the right child is null, and if it is, it returns the node's left child.
 If the left child is null, it returns the node's right child.
 If neither of the children are null, it sets a temporary node (t) to the node, sets the node to the minimum of the right child (min(t.right)),
 sets the right child of the node to the result of the deleteMin function on the right child of the temporary node (deleteMin(t.right)),
 and sets the left child of the node to the left child of the temporary node (t.left). */
    private Node delete(Node x, Key key){
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp < 0) x.left = delete(x.left,key);
        else if (cmp > 0) x.right = delete(x.right, key);
        /*checks if the node has no left or right children, and if so, returns either the left or right child. If the node has two children,
        it sets the node equal to the minimum key value of the right subtree, and then deletes the minimum value of the right subtree.*/
        /*
        *        5
        *      /   \
        *    4      6
        *         6
         *      /   \
         *    4      6
         *        6
         *      /   \
         *    4      deletes
        * */
        else {
            if(x.right == null) return x.left;
            if(x.left == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    // Returns the smallest key in the symbol table.
    private Node min(Node x){
        if(x.left == null) return x;
        else return min(x.left);
    }

    //Removes the smallest key and associated value from the symbol table.
    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    //Returns the largest key in the symbol table.
    private Node max(Node x){
        if(x.right == null) return x;
        else return max(x.right);
    }

    // return number of key-value pairs in BST rooted at x
    private int size(Node x){
        if(x == null) return 0;
        else return x.size;
    }


    //Driver Code
    public static void main(String[] args) {
        BinarySearchTree<String, Integer> st = new BinarySearchTree<String, Integer>();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; sc.hasNext(); i++) {
            String key = sc.next();
            st.put(key, i);
        }

//        for (String s : st.levelOrder())
//            System.out.println(s + " " + st.get(s));
//
//        System.out.println();
//
//        for (String s : st.keys())
//            System.out.println(s + " " + st.get(s));
    }

}
