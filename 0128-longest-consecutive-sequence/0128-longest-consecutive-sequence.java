class Solution {
    public int longestConsecutive(int[] nums) {
        var set = new HashSet<Integer>();
        for (int n : nums) set.add(n);

        int longest = 0;
        for (int n : set) {
            if (!set.contains(n - 1)) {
                int l = 1;
                while (set.contains(n + l)) l++;

                longest = Math.max(longest, l);
            }
        }
        return longest;
    }
}