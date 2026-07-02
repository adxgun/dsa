class TwoSum {

    private HashMap<Integer, Integer> counts;

    public TwoSum() {
        counts = new HashMap<>();
    }
    
    public void add(int number) {
        counts.merge(number, 1, Integer::sum);
    }
    
    public boolean find(int value) {
        for (int x : counts.keySet()) {
            int compliment = value - x;
            if (compliment == x) {
                if (counts.get(x) >= 2) return true;
            } else if (counts.containsKey(compliment)) return true;
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */