class Solution {
    public int minElement(int[] nums) {
        int res = Integer.MAX_VALUE;
        for (int x : nums) {
            res = Math.min(sumString(String.valueOf(x)), res);
        }

        return res;
    }

    private int sumString(String s) {
        int total = 0;
        for (char ch : s.toCharArray()) total += (ch - '0');
        return total;
    }
}