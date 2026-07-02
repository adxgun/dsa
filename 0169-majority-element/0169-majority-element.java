class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0, count = 0;
        for (int x : nums) {
            if (count == 0) candidate = x; //adopt;

            count += (candidate == x) ? 1 : -1;
        }

        return candidate;
    }
}