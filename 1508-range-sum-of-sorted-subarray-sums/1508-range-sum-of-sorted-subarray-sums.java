class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int MOD = 1_000_000_007;
        int[] sums = new int[n * (n + 1) / 2];

        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            int running = 0;
            for (int j = i; j < nums.length; j++) {
                running += nums[j];
                sums[idx++] = running;
            }
        }

        Arrays.sort(sums);
        long total = 0;
        for (int i = left - 1; i < right; i++) {
            total = (total + sums[i]) % MOD;
        }
        return (int) total;
    }
}