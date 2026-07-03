class MyHashSet {

    private final int BUCKETS = 1000;
    private final LinkedList<Integer>[] buckets;
    
    public MyHashSet() {
        buckets = new LinkedList[BUCKETS];
        for (int i = 0; i < BUCKETS; i++) {
            buckets[i] = new LinkedList<>();
        }
    }
    
    public void add(int key) {
        LinkedList<Integer> bucket = buckets[hash(key)];
        if (!bucket.contains(key)) {
            bucket.add(key);
        }
    }
    
    public void remove(int key) {
        LinkedList<Integer> bucket = buckets[hash(key)];
        bucket.remove(Integer.valueOf(key));
    }
    
    public boolean contains(int key) {
        LinkedList<Integer> bucket = buckets[hash(key)];
        return bucket.contains(Integer.valueOf(key));
    }

    private int hash(int value) {
        return value % BUCKETS;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */