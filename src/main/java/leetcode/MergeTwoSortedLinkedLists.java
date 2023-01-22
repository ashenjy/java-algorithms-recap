package leetcode;

public class MergeTwoSortedLinkedLists {

    public MergeTwoSortedLinkedLists(){

    }

    /*Merge two sorted linked lists and return it as a new sorted list.*/
     static class ListNode{

        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }
    /*Approach
    * l1 = 1 -> 3 -> 10
    * l2 = 5 -> 6 -> 9
    * l3 = null
    * compare the first two nodes in both lists, (1,5) 1 is smaller so add it to the new list and move the pointer in l1
     * l1 = 3 -> 10
     * l2 = 5 -> 6 -> 9
     * l3 = 1, 3
     * compare the first two nodes in both lists, (3,5) 3 is smaller so add it to the new list and move the pointer in l1
     * ...
     * l1 = 10
     * l2 = 5 -> 6 -> 9
     * l3 = 1, 3, 5
     * compare the first two nodes in both lists, (10,5) 5 is smaller so add it to the new list and move the pointer to l2
     * * */
    public static ListNode mergeTwoSortedLinkedLists(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }

        if(l2 == null){
            return l1;
        }

        //Create New List
        ListNode l3 = new ListNode(-1);
        ListNode p = l3;

        //while both linked lists are not empty
        while(l1 != null && l2 != null){
            //Find the smaller element and append it to the list.
            if(l1.val <= l2.val){
                p.next = l1;
                l1 = l1.next;
            }else{
                p.next = l2;
                l2 = l2.next;
            }
            //update the variable.
            p = p.next;
        }
        //once we reach end of a linked list, append the other list because we know it is already sorted.
        if(l1 == null){
            p.next = l2;
        }
        if(l2 == null){
            p.next = l1;
        }

        // return the sorted linked list
        return l3.next;
    }

    static void printList(ListNode node){
        while(node != null){
            System.out.println(node.val + " ");
            node = node.next;
        }
    }

    //driver code
    public static void main(String[] args){
        //LinkedList 1 = 1 -> 3 -> 5
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(10);

        //LinkedList 1 = 0 -> 2 -> 4
        ListNode head2 = new ListNode(5);
        head2.next = new ListNode(6 );
        head2.next.next = new ListNode(9);

        ListNode mergedHead = MergeTwoSortedLinkedLists.mergeTwoSortedLinkedLists(head1, head2);

        printList(mergedHead);

    }
}


