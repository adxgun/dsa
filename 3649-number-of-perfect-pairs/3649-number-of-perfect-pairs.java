class Solution {
    public long perfectPairs(int[] nums) {
        int n = nums.length;
        long[] abs = new long[n];
        for (int i = 0; i < n; i++) {
            abs[i] = Math.abs((long) nums[i]);
        }
        
        Arrays.sort(abs);
        long count = 0;
        int left = 0;
        for (int j = 0; j < n; j++) {
            while (2 * abs[left] < abs[j]) {
                left++;
            }

            count += j - left;
        }
        return count;
    }
}