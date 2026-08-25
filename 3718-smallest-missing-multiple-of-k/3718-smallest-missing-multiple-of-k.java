class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> values = new HashSet<>();
        for (int x : nums) values.add(x);
        
        int c = k;
        while (values.contains(c)) c += k;
        return c;
    }
}