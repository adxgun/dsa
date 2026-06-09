class Solution {
    public int maximumStrongPairXor(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int x = nums[i], y = nums[j];
                if (Math.abs(x - y) <= Math.min(x, y)) max = Math.max(max, nums[i] ^ nums[j]);
            }
        }
        return max;
    }
}