class Solution {
    public int maxFrequency_SW(int[] nums, int k) {
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

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;

        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) prefix[i + 1] = prefix[i] + nums[i];

        int maxFreq = 0;
        for (int right = 0; right < n; right++) {

            int lo = 0, hi = right;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (cost(prefix, mid, right, nums[right]) <= k) {
                    hi = mid;
                } else lo = mid + 1;
            }

            maxFreq = Math.max(maxFreq, right - lo + 1);
        }
        return maxFreq;
    }

    private long cost(long[] prefix, int left, int right, int target) {
        int size = right - left + 1;
        long windowSum = prefix[right + 1] - prefix[left];
        return (long) target * size - windowSum;
    }
}