package algorithms.hashtables;

/*
*  simple implementation of HashMap in Java using an array of a linked list.
* */

public class MyMap<K,V>{

    private Entry[] buckets;
    private static final int INITIAL_CAPACITY = 16;
    private int size = 0;

    public MyMap(){
        buckets = new Entry[INITIAL_CAPACITY];
    }

    public MyMap(int capacity){
        buckets = new Entry[capacity];
    }

    public void put(K key, V val){
        //creates an entry (key-value pair) with a null next pointer
        Entry<K,V> entry = new Entry<>(key,val,null);
        //calculates the bucket to which the key-value pair should be added
        int bucket = getHash(key) % getBucketSize();
        //checks if there are any existing entries in that bucket
        Entry existing = buckets[bucket];
        if(existing == null){
            //If there are none, the new entry is added to the bucket.
            buckets[bucket] = entry;
            size++;
        }else{
            //If there are,
            //the code iterates through the entries to check if the key already exists.
            while (existing.next != null) {
                if (existing.key.equals(key)) {
                    //If it does, the value is updated.
                    existing.val = val;
                    return;
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

    private int getHash(K key) {
        return key == null ? 0 : Math.abs(key.hashCode());
    }

    private int getBucketSize() {
        return buckets.length;
    }

    static class Entry<K,V> {
        final K key;
        V val;
        Entry<K, V> next;

        Entry(K key, V val, Entry<K, V> next){
            this.key = key;
            this.val = val;
            this.next = next;
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            return super.equals(o);
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }


    public static void main(String[] args){
        MyMap<Integer, String> hme = new MyMap<Integer, String>();
        hme.put(123,"sads");

        if(hme.contains(123)){
            System.out.println(hme.get(123));
        }

        for(Integer i: hme){
            System.out.println(i);
        }
    }
}
