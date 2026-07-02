class Solution {
    public int maximumGap2(int[] nums) {
        if (nums.length < 2) return 0;
        Arrays.sort(nums);

        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(nums[i] - nums[i - 1], max);
        }

        return max;
    }

    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;

        int lo = Integer.MAX_VALUE, hi = Integer.MIN_VALUE;
        for (int x : nums) {
            lo = Math.min(lo, x);
            hi = Math.max(hi, x);
        }
        if (lo == hi) return 0;   // all elements equal -> no gap

        // bucket width: at least 1, sized to the average gap (ceiling)
        int bucketSize = Math.max(1, (hi - lo) / (n - 1));
        int bucketCount = (hi - lo) / bucketSize + 1;

        int[] bucketMin = new int[bucketCount];
        int[] bucketMax = new int[bucketCount];
        java.util.Arrays.fill(bucketMin, Integer.MAX_VALUE);
        java.util.Arrays.fill(bucketMax, Integer.MIN_VALUE);

        // drop each number into its bucket, tracking only that bucket's min/max
        for (int x : nums) {
            int idx = (x - lo) / bucketSize;
            bucketMin[idx] = Math.min(bucketMin[idx], x);
            bucketMax[idx] = Math.max(bucketMax[idx], x);
        }

        // the max gap spans from one bucket's max to the next non-empty bucket's min
        int maxGap = 0;
        int prevMax = lo;   // running max of the last non-empty bucket
        for (int i = 0; i < bucketCount; i++) {
            if (bucketMin[i] == Integer.MAX_VALUE) continue;   // empty bucket, skip
            maxGap = Math.max(maxGap, bucketMin[i] - prevMax);
            prevMax = bucketMax[i];
        }
        return maxGap;
    }
}