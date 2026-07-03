class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length, pos = n - 1;
        int[] res = new int[n];
        int left = 0, right = n - 1;
        while (left <= right) {
            int leftSqrt = nums[left] * nums[left];
            int rightSqrt = nums[right] * nums[right];
            if (leftSqrt > rightSqrt) {
                res[pos] = leftSqrt;
                left++;
            } else {
                res[pos] = rightSqrt;
                right--;
            }
            pos--;
        }
        return res;
    }
}