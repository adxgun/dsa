class Solution {
    public long countSubarraysA(int[] nums, int k) {
        int maxElem = -1, left = 0, n = nums.length;
        long len = 0;
        for (int x : nums) maxElem = Math.max(maxElem, x);

        var freq = new HashMap<Integer, Integer>();
        for (int right = 0; right < n; right++) {
            freq.merge(nums[right], 1, Integer::sum);

            while(freq.get(maxElem) != null && freq.get(maxElem) >= k) {
                if (freq.merge(nums[left], -1, Integer::sum) == 0) freq.remove(nums[left]);
                left++;
            }

            len += left;
        }
        return len;
    }

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