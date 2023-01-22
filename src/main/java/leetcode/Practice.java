package leetcode;

import java.util.NoSuchElementException;
import java.util.Scanner;
//Implement a basic Stack data structure using an array
public class Practice<Item> {
    private Item[] items;
    private static final int INITIAL_CAPACITY = 8;
    int n;

    Practice(){
        items = (Item[]) new Object[INITIAL_CAPACITY];
        n=0;
    }

    //add an element to the stack
    public void push(Item item){
        //resize
        if(n == items.length) resize(2* items.length);
        items[n++] = item;
    }

    public Item pop(){
        if(n == 0) throw new NoSuchElementException("Stck Underflow");
        //recent element
        Item recentElement = items[n-1];
        items[n-1] = null;
        n--;
        return recentElement;
    }

    public void resize(int capacity){
        assert capacity >= n;
        Item[] copy = (Item[]) new Object[capacity];
        for(int i=0; i < n; i++){
            copy[i] = items[i];
        }
        items = copy;
    }

    public static void main(String[] args){
        Practice<String> p = new Practice<>();
        p.push("test1");
        p.push("test2");

        p.pop();
        p.push("test3");
    }
}
