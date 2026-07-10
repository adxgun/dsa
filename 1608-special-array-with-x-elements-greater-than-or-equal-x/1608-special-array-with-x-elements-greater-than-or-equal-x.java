class Solution {
    public int specialArray(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < 1000; i++) {
            int count = 0;
            for (int x : nums) if (x >= i) count++;

            if (count == i) return count;
        }
        return -1;
    }
}