class Solution {
    public int[] twoSum(int[] nums, int target) {
        /*for (int i = 0; i < nums.length; i++) {
            for (int k = 1; k < nums.length; k++) {
                int value = nums[i] + nums[k];
                if (value == target && i != k) {
                    return new int[]{i, k};
                }
            }
        }
        return new int[]{0,0};*/
        final var cache = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int value = target - nums[i];
            if (cache.containsKey(value)) {
                return new int[]{cache.get(value), i};
            } else {
                cache.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }
}