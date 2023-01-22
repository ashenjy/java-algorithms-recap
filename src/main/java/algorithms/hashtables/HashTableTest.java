package algorithms.hashtables;

import org.junit.Test;

import static org.junit.Assert.*;

public class HashTableTest {
    public HashTableTest() {
    }

    // test the put method
    @Test
    public void testPut() {
        // create a new HashTable
        HashTableSeperateChaining ht = new HashTableSeperateChaining(10);
        // add a key-value pair
        ht.put("a", 1);
        ht.put("b", 2);
        // check if the value of the key is correct
        assertEquals(1, ht.get("a"));
        assertEquals(2, ht.get("b"));
        // update the value of the key
        ht.put("a", 3);
        // check if the value is updated
        assertEquals(3, ht.get("a"));
    }

    // test the get method
    @Test
    public void testGet() {
        // create a new HashTable
        HashTableSeperateChaining ht = new HashTableSeperateChaining(10);
        // add a key-value pair
        ht.put("a", 1);
        // check if the value of the key is correct
        assertEquals(1, ht.get("a"));
        // check if the non-existent key is handled correctly
        assertNull(ht.get("b"));
    }

    // test the remove method
    @Test
    public void testRemove() {
        // create a new HashTable
        HashTableSeperateChaining ht = new HashTableSeperateChaining(10);
        // add a key-value pair
        ht.put("a", 1);
        // check if the value of the key is correct
        assertEquals(1, ht.get("a"));
        // remove the key-value pair
        ht.remove("a");
        // check if the key-value pair is removed
        assertNull(ht.get("a"));
    }

    // test the hash function
    @Test
    public void testHashFunction() {
        // create a new HashTable
        HashTableSeperateChaining ht = new HashTableSeperateChaining(10);
        // determine the bucket index for a key
        int index = ht.hash("a");
        // check if the index is within the size of the buckets array
        assertTrue(index < 10);
    }

    // test the collision
    @Test
    public void testCollision() {
        // create a new HashTable
        HashTableSeperateChaining ht = new HashTableSeperateChaining(10);
        // add two keys that have the same hash code
        ht.put("a", 1);
        ht.put("b", 2);
        // check if the two keys have the same bucket index
        assertNotEquals(ht.hash("a"), ht.hash("b"));
        // check if the value of the two keys are correct
        assertEquals(1, ht.get("a"));
        assertEquals(2, ht.get("b"));
    }
}
