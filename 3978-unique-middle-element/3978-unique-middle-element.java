class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
        int count = 0, n = nums.length;
        int mid = nums[n / 2];

        for (int x : nums) {
            if (x == mid) count++;
            if (count > 1) return false;
        }

        return true;
    }
}