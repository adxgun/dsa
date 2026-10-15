class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int run = 1, best = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) run++;
            else run = 1;

            best = Math.max(best, run);
        }

        return best;
    }
}