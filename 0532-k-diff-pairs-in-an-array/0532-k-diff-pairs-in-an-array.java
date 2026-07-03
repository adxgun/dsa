class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0;
        
        Arrays.sort(nums);
        int count = 0, lo = 0, hi = 1;

        while (hi < nums.length) {
            int diff = nums[hi] - nums[lo];
            if (diff == k) {
                count++;
                lo++;
                hi++;
                // skip duplicates
                while (lo < hi && nums[lo] == nums[lo - 1]) lo++;
                while (hi < nums.length && nums[hi] == nums[hi - 1]) hi++;
            } else if (diff < k) {
                hi++;
            } else {
                lo++;
            }
            
            if (lo == hi) hi++; // pointers must not overlap
        }
        return count;
    }

    public int findPairsA(int[] nums, int k) {
        if (k < 0) return 0;
        java.util.Arrays.sort(nums);
        int count = 0, left = 0, right = 1, n = nums.length;
        while (right < n) {
            int diff = nums[right] - nums[left];
            if (left == right || diff < k) {
                right++;                       // gap too small (or pointers coincide): widen
            } else if (diff > k) {
                left++;                        // gap too big: shrink
            } else {
                count++;                       // found a pair
                left++;
                while (left < n && nums[left] == nums[left - 1]) left++;  // skip duplicate lefts
            }
        }
        return count;
    }
}