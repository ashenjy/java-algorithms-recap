package algorithms.hashtables;

/*
 *  simple implementation of HashMap in Java using an array of a linked list.
 * */

public class MyMap<K, V> {

    private Entry<K, V>[] buckets;
    private static final int INITIAL_CAPACITY = 16;
    private int size = 0;

    public MyMap() {
        buckets = new Entry[INITIAL_CAPACITY];
    }

    public MyMap(int capacity) {
        buckets = new Entry[capacity];
    }

    public void put(K key, V val) {
        //creates an entry (key-value pair) with a null next pointer
        Entry<K, V> entry = new Entry<>(key, val, null);
        //calculates the bucket to which the key-value pair should be added
        int bucket = getBucketIndex(key);
        //checks if there are any existing entries in that bucket
        Entry existing = buckets[bucket];
        if (existing == null) {
            //If there are none, the new entry is added to the bucket.
            buckets[bucket] = entry;
            size++;
        } else {
            //If there are,
            //the code iterates through the entries to check if the key already exists.
            while (existing.next != null) {
                if (existing.key.equals(key)) {
                    //If it does, the value is updated.
                    existing.val = val;
                }
                existing = existing.next;
            }
            if (existing.key.equals(key)) {
                existing.val = val;
            } else {
                //If the key does not exist, it adds a new entry to the linked list with the key and value
                existing.next = entry;
                size++;
            }
        }
    }

    public V get(K key) {
        if (key == null) throw new IllegalArgumentException("Key param is null!");
        Entry<K, V> bucket = findElement(getBucketIndex(key));
        while (bucket != null) {
            if (bucket.key.equals(key)) {
                return bucket.val;
            }
            bucket = bucket.next;
        }
        return null;
    }

    public boolean contains(K key) {
        if (key == null) throw new IllegalArgumentException("Key param is null!");
        int bucket = getBucketIndex(key);
        //checks if there are any existing entries in that bucket
        Entry<K, V> existing = findElement(bucket);
        if (existing != null) {
            return existing.key.equals(key);
        }
        return false;
    }

    private Entry<K, V> findElement(int index) {
        return buckets[index];
    }

    private int getHash(K key) {
        return key == null ? 0 : Math.abs(key.hashCode());
    }

    private int getBucketSize() {
        return buckets.length;
    }

    private int getBucketIndex(K key) {
        return getHash(key) % getBucketSize();
    }

    public Entry<K, V>[] getBuckets() {
        return buckets;
    }

    static class Entry<K, V> {
        final K key;
        V val;
        Entry<K, V> next;

        Entry(K key, V val, Entry<K, V> next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return val;
        }
    }


    public static void main(String[] args) {
        MyMap<Integer, String> myMap = new MyMap<Integer, String>();
        myMap.put(123, "test1");
        myMap.put(321, "test3");
        myMap.put(444, "test4");
        myMap.put(123, "test2");

        if (myMap.contains(123)) {
            System.out.println("true");
            System.out.println(myMap.get(123));
        }

        for(Entry entry: myMap.getBuckets()){
            while(entry != null){
                System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
                entry = entry.next;
            }
        }
    }
}
