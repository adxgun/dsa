class Solution {

    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) return nums[i];
        }
        return -1;
    }

    public int findDuplicate1(int[] nums) {
        int lo = 1, hi = nums.length - 1;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            int count = 0;
            for (int num : nums) {
                if (num <= mid) count++;
            }

            if (count > mid) {
                hi = mid;       // duplicate in [lo, mid]
            } else {
                lo = mid + 1;   // duplicate in [mid+1, hi]
            }
        }

        return lo;
    }
}