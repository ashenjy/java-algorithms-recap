package algorithms.hashtables;

import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

/* HashTableSeperateChaining Collision Resolution Solution using LinkedLists only for the buckets which has multiple keys.
* */
public class HashTableSeperateChaining {
    // buckets is an array of type LinkedList
    private LinkedList<Object>[] buckets;
    private static final int INITIAL_CAPACITY = 16;

    //Constructor
    public HashTableSeperateChaining(int size) {
        // initialize the buckets array with given size
        buckets = new LinkedList[size];
    }

    // hash function to determine the bucket index
    int hash(Object key) {
        // use the hashCode of the key
        int hashCode = key.hashCode();
        // modulo to fit the size of the buckets array
        int index = hashCode % buckets.length;
        return index;
    }

    // add a key-value pair
    public void put(Object key, Object value) {
        // first use the hash function to determine the bucket index
        int bucketIndex = hash(key);
        // if the bucket is empty, create a new linked list and add the key-value
        if (buckets[bucketIndex] == null) {
            buckets[bucketIndex] = new LinkedList<>();
            buckets[bucketIndex].add(key);
            buckets[bucketIndex].add(value);
            // if the bucket is not empty, traverse through the linked list
        } else {
            // if the key already exists, update the value
            for (int i = 0; i < buckets[bucketIndex].size(); i += 2) {
                if (buckets[bucketIndex].get(i).equals(key)) {
                    buckets[bucketIndex].set(i + 1, value);
                    return;
                }
            }
            // if the key does not exist, add the key-value pair
            buckets[bucketIndex].add(key);
            buckets[bucketIndex].add(value);
        }
    }

    // get the value of the given key
    public Object get(Object key) {
        // first use the hash function to determine the bucket index
        int bucketIndex = hash(key);
        // if the bucket is empty, return null
        if (buckets[bucketIndex] == null) {
            return null;
            // if the bucket is not empty, traverse through the linked list
        } else {
            // if the key exists, return the corresponding value
            for (int i = 0; i < buckets[bucketIndex].size(); i += 2) {
                if (buckets[bucketIndex].get(i).equals(key)) {
                    return buckets[bucketIndex].get(i + 1);
                }
            }
        }
        // if the key does not exist, return null
        return null;
    }

    // remove the given key
    public void remove(Object key) {
        // first use the hash function to determine the bucket index
        int bucketIndex = hash(key);
        // if the bucket is empty, do nothing
        if (buckets[bucketIndex] == null) {
            return;
            // if the bucket is not empty, traverse through the linked list
        } else {
            // if the key exists, remove the corresponding key-value pair
            for (int i = 0; i < buckets[bucketIndex].size(); i += 2) {
                if (buckets[bucketIndex].get(i).equals(key)) {
                    buckets[bucketIndex].remove(i);
                    buckets[bucketIndex].remove(i);
                    return;
                }
            }
        }
    }
}

