class Solution {
    public int findFinalValue(int[] nums, int original) {
        Map<Integer, Integer> values = new HashMap<>();
        for (int x : nums) values.put(x, x);

        while (values.get(original) != null) {
            original *= 2;
        }
        return original;
    }
}