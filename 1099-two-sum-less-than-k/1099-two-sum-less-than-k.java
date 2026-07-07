class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        int i = 0, j = nums.length - 1, max = -1;
        Arrays.sort(nums);
        
        while (i < j) {
            if (nums[i] + nums[j] < k) {
                max = Math.max(max, nums[i] + nums[j]);
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}