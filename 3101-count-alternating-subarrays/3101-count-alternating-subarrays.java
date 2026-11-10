class Solution {
    public long countAlternatingSubarrays(int[] nums) {
        long total = 0, run = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] != nums[i - 1]) run++;
            else run = 1;
            
            total += run;
        }

        return total;
    }
}