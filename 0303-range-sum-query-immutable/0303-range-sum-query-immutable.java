class NumArray {

    private int[] runningSum;
    public NumArray(int[] nums) {
        runningSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            runningSum[i + 1] = runningSum[i] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        return runningSum[right + 1] - runningSum[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */