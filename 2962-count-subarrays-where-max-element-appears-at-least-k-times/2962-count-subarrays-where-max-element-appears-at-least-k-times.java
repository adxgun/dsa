class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxElem = 0;
        for (int x : nums) maxElem = Math.max(maxElem, x);

        long count = 0;
        int left = 0, maxCount = 0;
        int n = nums.length;

        for (int right = 0; right < n; right++) {
            if (nums[right] == maxElem) maxCount++;

            // Shrink from the left while we still have at least k maxes
            while (maxCount >= k) {
                if (nums[left] == maxElem) maxCount--;
                left++;
            }

            // Now [0..left-1] are valid start positions for subarrays ending at `right`
            count += left;
        }
        return count;
    }
}