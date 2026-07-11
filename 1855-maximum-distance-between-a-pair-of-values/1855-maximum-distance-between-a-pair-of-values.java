class Solution {
    public int maxDistanceA(int[] nums1, int[] nums2) {
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

    public int maxDistance(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int dist = 0;

        for (int i = 0; i < n1; i++) {
            // largest j in nums2 with nums2[j] >= nums1[i] (nums2 is non-increasing)
            int j = lastAtLeast(nums2, i, nums1[i]);
            if (j >= i) {
                dist = Math.max(dist, j - i);
            }
        }
        return dist;
    }

    // in a non-increasing array, find the largest index j (>= startFrom) with nums[j] >= val;
    // returns -1 if none
    private int lastAtLeast(int[] nums, int startFrom, int val) {
        int lo = startFrom, hi = nums.length - 1, result = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] >= val) {
                result = mid;      // this qualifies; look further right for a larger index
                lo = mid + 1;
            } else {
                hi = mid - 1;      // too small; qualifying values are to the left
            }
        }
        return result;
    }
}