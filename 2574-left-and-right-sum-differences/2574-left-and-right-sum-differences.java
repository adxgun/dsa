class Solution {
    public int[] leftRightDifference(int[] nums) {
        int total = 0;
        for (int x : nums) total += x;

        int n = nums.length, leftSum = 0;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int rightSum = total - leftSum - nums[i];
            ans[i] = Math.abs(rightSum - leftSum);
            leftSum += nums[i];
        }

        return ans;
    }
}