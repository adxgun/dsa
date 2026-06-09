class Solution {
    public int maximumLength(String s) {
        var freq = new HashMap<String, Integer>();
        int n = s.length(), max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String sub = s.substring(i, j);
                if (isSpecial(sub)) {
                    if (freq.merge(sub, 1, Integer::sum) >= 3) max = Math.max(max, sub.length());
                }
            }
        }
        return max == Integer.MIN_VALUE ? -1 : max;
    }

    private boolean isSpecial(String s) {
        if (s.length() == 1) return true;
        for (int i = 0; i + 1 < s.length(); i++) {
            if (!(s.charAt(i) == s.charAt(i + 1))) return false;
        }
        return true;
    }
}