class Solution {
    public int missingInteger(int[] nums) {
        int sum = nums[0];
        for (int i = 1; i < nums.length && nums[i] == nums[i - 1] + 1; i++) {
            sum += nums[i];
        }

        Set<Integer> seen = new HashSet<>();
        for (int x : nums) seen.add(x);

        while (seen.contains(sum)) sum++;
        return sum;
    }
}