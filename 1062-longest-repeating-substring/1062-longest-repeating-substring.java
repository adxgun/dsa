class Solution {
    public int longestRepeatingSubstring(String s) {
        int n = s.length();
        int lo = 1, hi = n - 1, answer = 0;   // max possible repeating length is n-1

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (hasRepeatingSubstring(s, mid)) {
                answer = mid;      // length mid works -> try longer
                lo = mid + 1;
            } else {
                hi = mid - 1;      // too long -> shrink
            }
        }
        return answer;
    }

    // does any substring of length L appear at least twice?
    private boolean hasRepeatingSubstring(String s, int L) {
        java.util.Set<String> seen = new java.util.HashSet<>();
        for (int i = 0; i + L <= s.length(); i++) {
            String sub = s.substring(i, i + L);
            if (!seen.add(sub)) {   // add returns false if already present -> duplicate found
                return true;
            }
        }
        return false;
    }
}