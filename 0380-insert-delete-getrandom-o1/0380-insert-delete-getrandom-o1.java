class RandomizedSet {

    private LinkedList<Integer> store;
    private Random rand;

    public RandomizedSet() {
        store = new LinkedList<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if (store.contains(Integer.valueOf(val))) return false;
        store.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        return store.removeIf(v -> v == val);
    }
    
    public int getRandom() {        
        int idx = rand.nextInt(store.size());
        return store.get(idx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */