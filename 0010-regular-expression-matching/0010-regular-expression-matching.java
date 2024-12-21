class Solution {

    private int[][] memo;

    public boolean isMatch(String s, String p) {
        memo = new int[s.length() + 1][p.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= p.length(); j++) {
                memo[i][j] = -1;
            }
        }

        return matches(s, p, 0, 0);
    }

    private boolean matches(String s, String p, int i, int j) {
        if (memo[i][j] != -1) {
            return memo[i][j] == 1;
        }

        boolean result = false;
        if (j == p.length()) {
            result = i == s.length();
        } else {
            boolean nextIsStar = (j + 1 < p.length()) && p.charAt(j + 1) == '*';
            boolean match = (i < s.length()) && 
                (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

            if (!nextIsStar) {
                // No '*' after p[j] so it must match single char
                result = match && matches(s, p, i + 1, j + 1);
            } else {
                // Next pattern char is '*'
                // Option 1: Skip the '*' (and its preceding char)
                // Option 2: If there's a match for current char, consume it and stay on pattern
                boolean option1 = matches(s, p, i, j + 2);
                boolean option2 = match && matches(s, p, i + 1, j);
                result = option1 || option2;
            }
        }
        memo[i][j] = result ? 1 : 0;
        return result;
    }
}