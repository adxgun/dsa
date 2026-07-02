class Solution {
    public int subarraySum(int[] nums, int k) {
        // maps a prefix-sum value -> how many times it has occurred
        java.util.HashMap<Integer, Integer> count = new java.util.HashMap<>();
        count.put(0, 1);          // empty prefix: sum 0 seen once (handles subarrays starting at index 0)

        int sum = 0, total = 0;
        for (int x : nums) {
            sum += x;                              // prefix sum up to current index
            total += count.getOrDefault(sum - k, 0);  // earlier prefixes that complete a sum-k subarray
            count.merge(sum, 1, Integer::sum);     // record current prefix
        }
        return total;
    }
}