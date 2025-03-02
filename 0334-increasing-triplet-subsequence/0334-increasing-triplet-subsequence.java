class Solution {
    // https://chatgpt.com/share/67c42bed-0a10-8005-9106-cc5ea4c3e62b
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }

        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int x : nums) {
            if (x <= firstMin) {
                firstMin = x;
            } else if (x <= secondMin) {
                secondMin = x;
            } else {
                return true; // firstMin < secondMin < x -> 1 < 2 < 3
            }
        }
        return false;
    }
}