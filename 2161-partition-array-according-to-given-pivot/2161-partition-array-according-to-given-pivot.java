class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int k = 0, n = nums.length;
        int[] res = new int[n];

        for (int x : nums) if (x < pivot) res[k++] = x;
        for (int x : nums) if (x == pivot) res[k++] = x;
        for (int x : nums) if (x > pivot) res[k++] = x;

        return res;
    }
}