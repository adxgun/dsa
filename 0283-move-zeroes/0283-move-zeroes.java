class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int pos = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[pos] = nums[i];
                pos++;
            }
        }

        for (int i = pos; i < n; i++) {
            nums[i] = 0;
        }
    }
}