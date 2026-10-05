class Solution {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] runningSum = new int[n];
        runningSum[0] = nums[0];

        for (int i = 1; i < n; i++) {
            runningSum[i] = nums[i] + runningSum[i - 1];
        }

        return runningSum;
    }
}