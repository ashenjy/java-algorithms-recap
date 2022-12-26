/*Problem Statement
Design a HashMap without using any built-in hash table libraries.

To be specific, your design should include these functions:

put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.*/

public class DesignHashMapOptimized {

    ListNode[] nodes;

    public DesignHashMapOptimized(){
        nodes = new ListNode[10000];
    }

    // add value into array
    public void put(int key, int value){
        //get the hashed index for the given key
        int index = getIndex(key);

        ListNode prev = findElement(index,key);

        //if prev.next is empty, put key,value pair here.
        if(prev.next == null){
            prev.next = new ListNode(key,value);
        }else
            //if not, replace the value for that index
            prev.next.val = value;

    }

    //returns value at a given key
    public int get(int key){
        //retrieve the hashed index
        int index = getIndex(key);

        ListNode prev = findElement(index,key);

        //if it is empty, then no value exists at that particular index
        if(prev.next == null){
            return -1;
        }else
            return prev.next.val;
    }

        //remove an element from the array
        public void remove(int key){
            int index = getIndex(key);
            ListNode prev = findElement(index,key);
            if(prev.next != null){
                //set the pointer of the previous node to the node after the node that is to be removed.
                // This allows the node to be removed from the linked list without causing any issues with the list's structure.
                prev.next = prev.next.next;
            }
        }


    //returns hashed index for the given key
    public int getIndex(int key){
        return Integer.hashCode(key)% nodes.length;
    }

    /*The function is given an index and a key as arguments, and it checks whether a value exists at the particular index.
    If it does not exist, the program creates a node with (-1,-1) and stores it in the array.
    If it does exist, the program traverses the array and searches for the given key.
    The function then returns the node before the node with the given key.*/
    public ListNode findElement(int index, int key){
        //if no value exists at the particular index, create a node with (-1,-1), store it in the array and return.
        if(nodes[index] == null)
            return nodes[index] = new ListNode(-1,-1);

        //if value exists at the particular index, traverse the array
        ListNode prev = nodes[index];

        while(prev.next != null && prev.next.key != key){
            prev = prev.next;
        }
        return prev;
    }

    /*ListNode represents a class that stores a node of a linked list.
    It contains an integer key, an integer value, and a reference to the next node in the list.*/
    static class ListNode{
        //key and value means the key-value pair for the nodes of a linked list.
        int key,val;
        ListNode next;

        ListNode(int key, int val){
         this.key = key;
         this.val = val;
        }
    }

}
