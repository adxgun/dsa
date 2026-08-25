class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> values = new HashSet<>();
        for (int x : nums) values.add(x);
        
        int c = k;
        while (values.contains(c)) {
            c = nextMultiple(c + 1, k);
        }
        return c;
    }

    private int nextMultiple(int n, int k) {
        while (n % k != 0) n++;
        return n;
    } 
}