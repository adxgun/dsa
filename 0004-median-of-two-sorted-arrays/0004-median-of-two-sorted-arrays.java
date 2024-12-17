class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // a = [1, 2], b = [3, 4]
        // merged = [1, 2, 3, 5]
        // mid = 2 + 3 / 2 => 5/2 = 2.5
        int n = nums1.length + nums2.length;
        int[] merged = new int[n];
        for (int i = 0; i < nums1.length; i++) {
            merged[i] = nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            merged[nums1.length + i] = nums2[i];
        }

        
        Arrays.sort(merged);

        boolean isEven = n % 2 == 0;
        int idx = (int) n / 2;
        return !isEven ? (double) merged[idx] : ((double)(merged[idx - 1] + merged[idx]) / 2);
    }
}