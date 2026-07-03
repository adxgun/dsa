class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;        // last real element in nums1
        int j = n - 1;        // last element in nums2
        int k = m + n - 1;    // write position, starting at the very end

        while (j >= 0) {      // continue until nums2 is fully merged
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];   // nums1's element is larger
            } else {
                nums1[k--] = nums2[j--];   // nums2's element is larger (or nums1 exhausted)
            }
        }
    }
}