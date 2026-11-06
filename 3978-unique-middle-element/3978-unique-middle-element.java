class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
        int n = nums.length, mid = n / 2;
        Map<Integer, Integer> count = new HashMap<>();
        int midVal = nums[mid];

        for (int x : nums) {
            count.merge(x, 1, Integer::sum);

            if (count.getOrDefault(midVal, 0) > 1) return false;
        }

        return true;
    }
}