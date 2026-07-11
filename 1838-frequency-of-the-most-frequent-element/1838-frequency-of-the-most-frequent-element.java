class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        long windowSum = 0;
        int left = 0, maxFreq = 0;

        for (int right = 0; right < nums.length; right++) {
            windowSum += nums[right];

            while ((long) nums[right] * (right - left + 1) - windowSum > k) {
                windowSum -= nums[left];
                left++;
            }

            maxFreq = Math.max(maxFreq, right - left + 1);
        }
        return maxFreq;
    }

    public int maxFrequencyA(int[] nums, int k) {
        return 0;
    }
}