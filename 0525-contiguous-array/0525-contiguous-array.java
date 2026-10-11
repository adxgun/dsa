class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> firstSeen = new HashMap<>();
        firstSeen.put(0, -1);
        
        int best = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] == 1) ? 1 : -1;

            if (firstSeen.containsKey(sum)) {
                best = Math.max(best, i - firstSeen.get(sum));
            } else {
                firstSeen.put(sum, i);
            }
        }

        return best;
    }
}

// [0:-1, -1:0, 1:2]
// sum = 0
// best = 0