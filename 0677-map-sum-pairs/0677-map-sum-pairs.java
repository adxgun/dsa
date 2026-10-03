class MapSum {

    private Map<String, Integer> sums;
    public MapSum() {
        sums = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        sums.put(key, val);
    }
    
    public int sum(String prefix) {
        int total = 0;
        for (Map.Entry<String, Integer> entry : sums.entrySet()) {
            String key = entry.getKey();
            if (key.startsWith(prefix)) total += entry.getValue();
        }

        return total;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */