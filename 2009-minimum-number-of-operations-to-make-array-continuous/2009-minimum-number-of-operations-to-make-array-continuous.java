class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;

        // sort and dedup: kept elements must be unique
        int[] sorted = java.util.Arrays.stream(nums).distinct().sorted().toArray();
        int uniqueCount = sorted.length;

        int maxKept = 0, left = 0;
        for (int right = 0; right < uniqueCount; right++) {
            // window must fit within width n: values in [sorted[left], sorted[left] + n - 1]
            // shrink left while sorted[right] falls outside that window
            while (sorted[right] - sorted[left] > n - 1) {
                left++;
            }
            // sorted[left..right] all fit in a valid continuous window
            maxKept = Math.max(maxKept, right - left + 1);
        }

        // operations = replace everything not kept
        return n - maxKept;
    }
}