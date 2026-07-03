class Solution {
    public int singleNonDuplicate(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid % 2 == 1) mid--;   // force mid to be even, aligning to pair starts

            if (nums[mid] == nums[mid + 1]) {
                // pairing still intact here -> single element is to the right
                lo = mid + 2;
            } else {
                // pairing broken -> single element is at mid or to the left
                hi = mid;
            }
        }
        return nums[lo];   // lo == hi lands on the single element
    }
}