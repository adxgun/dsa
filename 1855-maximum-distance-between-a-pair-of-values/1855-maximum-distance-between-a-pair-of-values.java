class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int dist = 0, n = nums1.length;
        for (int i = 0; i < n; i++) {
            // return the first idx of elem in nums2 >= x
            int idx = lower(nums2, nums1[i]);
            if (i <= idx && nums1[i] <= nums2[idx]) dist = Math.max(dist, idx - i);
        }
        return dist;
    }

    private int lower(int[] nums, int val) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < val) hi = mid - 1;
            else lo = mid + 1;
        }
        return lo - 1;
    }
}