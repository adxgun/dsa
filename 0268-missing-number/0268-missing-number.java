class Solution {
    public int missingNumber(int[] nums) {
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) map.put(nums[i], i + 1);

        for (int j = 0; j < nums.length; j++) {
            if (map.get(j + 1) == null) return j + 1;
        }

        return 0;
    }
}