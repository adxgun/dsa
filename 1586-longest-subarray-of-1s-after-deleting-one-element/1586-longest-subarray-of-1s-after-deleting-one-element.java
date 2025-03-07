class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        boolean allOnes = true;

        for (int x : nums) {
            if (x == 0) {
                allOnes = false;
            }
        }

        if (allOnes) {
            return n > 1 ? n - 1 : 0;
        }

        List<Integer> ones = new ArrayList<>();
        List<Integer> zeroPos = new ArrayList<>();

        int oneCounts = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                oneCounts++;
            } else {
                ones.add(oneCounts);
                oneCounts = 0;

                zeroPos.add(i);
            }
        }

        ones.add(oneCounts);
        int result = 0;

        for (int x : ones) {
            result = Math.max(result, x);
        }

        for (int i = 0; i < zeroPos.size(); i++) {
            int merged = ones.get(i) + (i + 1 < ones.size() ? ones.get(i + 1) : 0);
            result = Math.max(result, merged);
        }
        return result;
    }
}