class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) merged[k++] = nums1[i++];
            else merged[k++] = nums2[j++];
        }

        while (i < nums1.length) merged[k++] = nums1[i++];
        while (j < nums2.length) merged[k++] = nums2[j++];

        int l = 0, r = merged.length - 1, n = merged.length;
        int mid = l + (r - l) / 2;
        if (n % 2 != 0) return merged[mid];
        return (double) (merged[mid] + merged[mid + 1]) / 2;
    }
}