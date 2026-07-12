class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        int lo = 0, hi = removable.length, answer = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (isSubsequenceAfterRemoval(s, p, removable, mid)) {
                answer = mid;
                lo = mid + 1;
            } else hi = mid - 1;
        }
        return answer;
    }

    private boolean isSubsequenceAfterRemoval(String s, String t, int[] removable, int k) {
        boolean[] removed = new boolean[s.length()];
        for (int i = 0; i < k; i++) removed[removable[i]] = true;
        
        int j = 0;
        for (int i = 0; i < s.length() && j < t.length(); i++) {
            if (!removed[i] && s.charAt(i) == t.charAt(j)) {
                j++;
            }
        }

        return j == t.length();
    }
}