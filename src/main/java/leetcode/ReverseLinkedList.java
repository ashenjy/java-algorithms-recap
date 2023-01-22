package leetcode;

import java.util.LinkedList;

public class ReverseLinkedList {
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

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;           // prev                          p  c
        while (current != null){           // null [1->2->3->4->5]         [1  2->3->4->5]
            ListNode next = current.next;  // null [1  2->3->4->5]         [1  2->3->4->5]
            current.next = prev;           // null [1  2->3->4->5]         [1<-2  3->4->5]
            prev = current;                //      [1  2->3->4->5]         [1<-2  3->4->5]                         head
            current = next;                //      [1  2->3->4->5]         [1<-2  3->4->5]   ........ [1<-2<-3<-4<-5] null
        }                                  //       p  c                       p  c
        head = prev;
        return head;
    }

    // Driver Code
    public static void main(String[] args)
    {

    }

}
