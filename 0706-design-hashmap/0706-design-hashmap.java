class MyHashMap {

    private static final int SIZE = 769;
    private LinkedList<int[]>[] buckets;
    public MyHashMap() {
        buckets = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) buckets[i] = new LinkedList<>();
    }

    private int hash(int key) {
        return key % SIZE;
    }
    
    public void put(int key, int value) {
        LinkedList<int[]> bucket = buckets[hash(key)];
        for (int[] entry : bucket) {
            if (entry[0] == key) {
                entry[1] = value;
                return;
            }
        }

        bucket.add(new int[]{key, value});
    }
    
    public int get(int key) {
        LinkedList<int[]> bucket = buckets[hash(key)];
        for (int[] entry : bucket) {
            if (entry[0] == key) return entry[1];
        }
        return -1;
    }
    
    public void remove(int key) {
        LinkedList<int[]> bucket = buckets[hash(key)];
        bucket.removeIf(entry -> entry[0] == key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */