package algorithms.hashtables;

public class HashTable {
    // Hash table size
    private int size;
    // Array of entries in hash table
    private Entry[] entries;

    // Constructor
    public HashTable(int size) {
        this.size = size;
        this.entries = new Entry[size];

        // Initialize all the entries to null
        for (int i = 0; i < size; i++) {
            entries[i] = null;
        }
    }

    // Method to get the value for a given key
    public String get(String key) {
        // Calculate the hash of the key
        int hash = key.hashCode() % size;

        // Get the entry at the calculated hash
        Entry entry = entries[hash];

        // If the entry is null, return null
        if (entry == null) {
            return null;
        }

        // Otherwise, check if the key matches the entry's key
        else {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
            // If it doesn't match, return null
            else {
                return null;
            }
        }
    }

    // Method to put a key-value pair into the hash table
    public void put(String key, String value) {
        // Calculate the hash of the key
        int hash = key.hashCode() % size;

        // Create a new entry with the key and value
        Entry entry = new Entry(key, value);

        // Put the entry into the hash table at the calculated hash
        entries[hash] = entry;
    }

    // Inner class to represent an entry in the hash table
    private class Entry {
        private String key;
        private String value;

        public Entry(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }
    }
}