class Solution {
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> values = new HashSet<>();
        for (int x : nums) values.add(x);

        while (values.contains(original)) {
            original *= 2;
        }
        return original;
    }
}