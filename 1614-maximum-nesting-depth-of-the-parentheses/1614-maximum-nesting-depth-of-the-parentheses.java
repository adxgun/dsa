class Solution {
    public int maxDepth(String s) {
        int max = 0, count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            else if (c == ')') count--;

            max = Math.max(count, max);
        }
        return max;
    }
}