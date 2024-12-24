class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length, closestSum = Integer.MAX_VALUE / 2;

        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }

                if (sum < target) {
                    left += 1;
                } else if (sum > target) {
                    right -= 1;
                } else {
                    return sum;
                }
            }
        }
        return closestSum;
    }
}