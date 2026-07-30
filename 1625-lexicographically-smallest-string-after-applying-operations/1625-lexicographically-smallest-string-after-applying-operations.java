import java.util.*;

class Solution {
    private String best;

    public String findLexSmallestString(String s, int a, int b) {
        best = s;
        Set<String> visited = new HashSet<>();
        dfs(s, a, b, visited);
        return best;
    }

    private void dfs(String s, int a, int b, Set<String> visited) {
        // Already explored this state → stop (this is the "visited" guard)
        if (!visited.add(s)) return;

        // Process this node: is it the smallest so far?
        if (s.compareTo(best) < 0) {
            best = s;
        }

        // Neighbor 1: apply "add a to odd indices"
        dfs(add(s, a), a, b, visited);

        // Neighbor 2: apply "rotate right by b"
        dfs(rotate(s, b), a, b, visited);
    }

    // Operation: add `a` to every odd index, mod 10
    private String add(String s, int a) {
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i += 2) {
            int digit = (chars[i] - '0' + a) % 10;
            chars[i] = (char) ('0' + digit);
        }
        return new String(chars);
    }

    // Operation: rotate right by `b`
    private String rotate(String s, int b) {
        int n = s.length();
        b %= n;
        return s.substring(n - b) + s.substring(0, n - b);
    }
}