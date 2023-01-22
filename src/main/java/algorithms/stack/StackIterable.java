package algorithms.stack;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

/*
 *
 * */
public class StackIterable<Item> implements Iterable<Item>{
    private int N; // size of the stack
    private Node<Item> first; // top of the stack

    //    Node class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public StackIterable(){
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

    @Override
    public Iterator<Item> iterator() {
        return new LinkedIterator(first);
    }

    // Returns an iterator to this stack that iterates through the items in LIFO order.
    private class LinkedIterator implements Iterator<Item>{
        private Node<Item> current;

        public LinkedIterator(Node<Item> first){
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
    // Returns a string representation of this stack.
    public String toString(){
        StringBuilder s = new StringBuilder();
        for(Item item: this){
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }

    //test client
    public static void main(String[] args){
        StackIterable<String> stack = new StackIterable<>();
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String item = sc.next();
            if (!item.equals("-")) stack.push(item);
            else if (stack.isEmpty())  System.out.println("BAD INPUT");
            else                   System.out.print(stack.pop());
            System.out.println(stack);
            System.out.println("(" + stack.size() + " left on stack)");
        }
    }

}
