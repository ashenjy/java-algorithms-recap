////Definition for singly-linked list.
//public class ListNode {
//    int data;
////    Next is a pointer to the next node in the list
//    ListNode next;
//
//    ListNode() {
//    }
//
//    ListNode(int data) {
//        this.data = data;
//    }
//
//    ListNode(int data, ListNode next) {
//        this.data = data;
//        this.next = next;
//    }
//
//    //Represent the head and tail of the singly linked list
//    private ListNode head = null;
//    private ListNode tail = null;
//
//    //addAtEnd() will add a new node to the end of the list
//    public void addAtEnd(int data) {
//        //Create a new node
//        ListNode newNode = new ListNode(data);
//
//        //Checks if the list is empty
//        if(head == null) {
//            //If list is empty, both head and tail will point to new node
//            head = newNode;
//            tail = newNode;
//        }
//        else {
//            //newNode will be added after tail such that tail's next will point to newNode
//            tail.next = newNode;
//            //newNode will become new tail of the list
//            tail = newNode;
//        }
//    }
//
////    /display() will display all the nodes present in the list
//    public void display() {
//        //Node current will point to head
//        ListNode current = head;
//        if(head == null) {
//            System.out.println("List is empty");
//            return;
//        }
//        System.out.println("Adding nodes to the end of the list: ");
//        while(current != null) {
//            //Prints each node by incrementing pointer
//            System.out.print(current.data + " ");
//            current = current.next;
//        }
//        System.out.println();
//    }
//}
