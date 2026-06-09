class Solution {
    public long countSubarrays(int[] nums, int k) {
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
}