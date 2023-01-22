package algorithms.stack;

import org.omg.CORBA.Object;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

/*
 * *  Stack implementation with a resizing array.
 * */
public class ResizingArrayStack<Item> implements Iterable<Item>{

    // initial capacity of underlying resizing array
    private static final int INIT_CAPACITY = 8;
    private int n;  // no of elements in the stack
    private Item[] a; // array of items


    public ResizingArrayStack(){
        a = (Item[]) new Object[INIT_CAPACITY];
        n = 0;
    }
    // add an element to the stack
    public void push(Item item){
        if(n == a.length) resize(2*a.length); // double size of array if necessary
        a[n++] = item;
    }

    // resize the underlying array holding the elements
    public void resize(int capacity){
        assert capacity >= n;
        Item[] copy = (Item[]) new Object[capacity];
        for(int i=0; i < n; i++){
            copy[i] = a[i];
        }
        a = copy;
    }

    // delete and return the most recently added element.
    public Item pop(){
        if(isEmpty()) throw new NoSuchElementException("Stack Underflow");
        Item recentElement = a[n-1];
        a[n-1] = null; // to avoid loitering
        n--;
        // shrink size of array if necessary
        if (n > 0 && n == a.length/4) resize(a.length/2);
        return recentElement;
    }

    /**
     * Returns (but does not remove) the item most recently added to this stack.
     */
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return a[n-1];
    }


    // is the stack empty?
    public boolean isEmpty(){
        return n == 0;
    }

    // number of elements on the stack
    public int size(){
        return n;
    }

    // Returns an iterator to this stack that iterates through the items in LIFO order.
    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ReverseArrayIterator implements Iterator<Item> {
        private int i;

        public ReverseArrayIterator() {
            i = n-1;
        }

        public boolean hasNext() {
            return i >= 0;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return a[i--];
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
        ResizingArrayStack<String> stack = new ResizingArrayStack<>();
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
