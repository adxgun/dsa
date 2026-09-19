class Solution {
    public int findUnsortedSubarrayB(int[] nums) {
        int[] copied = new int[nums.length];
        for (int c = 0; c < copied.length; c++) {
            copied[c] = nums[c];
        }

        Arrays.sort(nums);
        int from = Integer.MAX_VALUE, to = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (copied[i] != nums[i]) {
                from = Math.min(from, i);
                to = Math.max(to, i);
            }
        }

        return from == Integer.MAX_VALUE ? 0 : (to - from) + 1;
    }

    public int findUnsortedSubarray(int[] nums) {
        int left = -1, right = -1, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] < max) right = i;
            else max = nums[i];

            if (nums[n - 1 - i] > min) left = n - 1 - i;
            else min = nums[n - 1 - i];
        }

        return right == -1 ? 0 : (right - left) + 1;
    }
}