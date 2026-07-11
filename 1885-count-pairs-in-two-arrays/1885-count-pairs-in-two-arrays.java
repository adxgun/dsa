class Solution {
    public long countPairs(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) diff[i] = nums1[i] - nums2[i];
        Arrays.sort(diff);

        long count = 0;
        int left = 0, right = n - 1;
        while (left < right) {
            if (diff[left] + diff[right] > 0) {
                count += right - left;
                right--;
            } else left++;
        }

        return count;
    }
}