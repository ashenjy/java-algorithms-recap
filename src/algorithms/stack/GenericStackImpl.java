package algorithms.stack;

import java.util.NoSuchElementException;
import java.util.Scanner;

/*
 *
 * */
public class GenericStackImpl<Item>{
    private int N; // size of the stack
    private Node<Item> first; // top of the stack

    //    Node class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public GenericStackImpl(){
        N = 0;
        first = null;
    }
    // add an element to the stack
    public void push(Item item){
        Node<Item> oldFirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldFirst;
        N++;
    }
    // delete and return the most recently added element.
    public Item pop(){
        if(isEmpty()) throw new NoSuchElementException("Stack Underflow");
        Item item = first.item;
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
        GenericStackImpl<String> s = new GenericStackImpl<>();
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String item = sc.next();
            if (!item.equals("-")) s.push(item);
            else if (s.isEmpty())  System.out.println("BAD INPUT");
            else                   System.out.print(s.pop());
        }
    }

}
