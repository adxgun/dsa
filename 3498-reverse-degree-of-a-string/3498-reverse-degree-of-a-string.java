class Solution {
    public int reverseDegree(String s) {
        int sum = 0, n = s.length();
        for (int i = 1; i <= n; i++) {
            sum += (26 - (s.charAt(i - 1) - 'a')) * i;
        }
        return sum;
    }
}