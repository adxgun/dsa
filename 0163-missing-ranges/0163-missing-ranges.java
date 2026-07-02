class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> result = new ArrayList<>();
        long expected = lower;   // next value we'd expect if nothing were missing

        for (int x : nums) {
            if (x > expected) {
                // gap: everything from `expected` up to x-1 is missing
                result.add(java.util.Arrays.asList((int) expected, x - 1));
            }
            expected = (long) x + 1;   // next expected value sits just past x
        }

        // trailing gap after the last element, up through upper
        if (expected <= upper) {
            result.add(java.util.Arrays.asList((int) expected, upper));
        }
        return result;
    }
}