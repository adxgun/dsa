class Solution {
    public int peakValleyDifference(int[] nums) {
        int peakSum = 0, valleySum = 0;
        for (int i = 1; i + 1 < nums.length; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) peakSum += nums[i];
            else if (nums[i] < nums[i - 1] && nums[i] < nums[i + 1]) valleySum += nums[i];
        }

        return (peakSum - valleySum);
    }
}