package algorithms.stack;

import java.util.NoSuchElementException;
import java.util.Scanner;

/*
*
* */
public class LinkedStackOfStrings {
    private int N; // size of the stack
    private Node first; // top of the stack

//    Node class
    private static class Node {
        private String item;
        private Node next;
    }

    public LinkedStackOfStrings(){
        N = 0;
        first = null;
    }
    // add an element to the stack
    public void push(String item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }
    // delete and return the most recently added element.
    public String pop(){
        if(isEmpty()) throw new NoSuchElementException("Stack Underflow");
        String item = first.item;
        first = first.next;  // delete first node
        N--;
        return item;
    }

    // is the stack empty?
    public boolean isEmpty(){
        return first == null;
    }

    // number of elements on the stack
    public int size(){
        return N;
    }

    //test client
    public static void main(String[] args){
        LinkedStackOfStrings s = new LinkedStackOfStrings();
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String item = sc.next();
            if (!item.equals("-")) s.push(item);
            else if (s.isEmpty())  System.out.println("BAD INPUT");
            else                   System.out.print(s.pop());
        }
    }

}
