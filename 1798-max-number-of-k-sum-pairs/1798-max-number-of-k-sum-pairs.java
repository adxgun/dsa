class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1, op = 0;

        while(left < right) {
            int sum = nums[left] + nums[right];
            if (sum > k) {
                right--;
            } else if (sum < k) {
                left++;
            } else {
                op += 1;
                nums[left] = 0;
                nums[right] = 0;
                right--;
            }
        }
        return op;
    }
}