class TimeMap {

    private Map<String, List<Pair<String, Integer>>> store;
    public TimeMap() {
        store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        store.computeIfAbsent(key, (a) -> new ArrayList<>()).add(new Pair<>(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<String, Integer>> pairs = store.get(key);
        if (pairs == null || pairs.size() == 0) return "";
        return binarySearch(pairs, timestamp);
    }

    private String binarySearch(List<Pair<String, Integer>> pairs, int timestamp) {
        int lo = 0, hi = pairs.size() - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            Pair<String, Integer> pair = pairs.get(mid);
            if (pair.getValue() <= timestamp) lo = mid + 1;
            else hi = mid - 1;
        }

        int idx = lo - 1;
        if (idx < 0) return "";
        return pairs.get(idx).getKey();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */