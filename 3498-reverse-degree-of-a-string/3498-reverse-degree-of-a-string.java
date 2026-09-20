class Solution {
    public int reverseDegree(String s) {
        int sum = 0, n = s.length();
        for (int i = 1; i <= n; i++) {
            int val = 26 - (s.charAt(i - 1) - 'a');
            sum += val * i;
        }
        return sum;
    }
}