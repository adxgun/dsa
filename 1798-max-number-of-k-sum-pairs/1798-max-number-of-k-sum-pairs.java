class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int ops = 0;
        int left = 0, right = nums.length - 1;

        while(left < right) {
            int sum = nums[left] + nums[right];
            if (sum > k) {
                right--;
            } else if (sum < k) {
                left++;
            } else {
                ops += 1;
                left++;
                right--;
            }
        }
        return ops;
    }
}