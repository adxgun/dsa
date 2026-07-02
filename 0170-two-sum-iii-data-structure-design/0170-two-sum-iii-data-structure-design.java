class TwoSum {

    private List<Long> nums;

    public TwoSum() {
        nums = new ArrayList<>();
    }
    
    public void add(int number) {
        nums.add((long) number);
    }
    
    public boolean find(int value) {
        Collections.sort(nums);
        int lo = 0, hi = nums.size() - 1;
        while(lo < hi) {
            long sum = nums.get(lo) + nums.get(hi);
            if (sum == (long) value) {
                return true;
            } else if (sum < value) {
                lo++;
            } else {
                hi--;
            }
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