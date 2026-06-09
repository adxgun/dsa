class Solution {
    public int findPattern(InfiniteStream stream, int[] pattern) {
        int n = pattern.length;

        // Build LPS (failure function) for the pattern
        int[] lps = new int[n];
        int k = 0;
        for (int i = 1; i < n; i++) {
            while (k > 0 && pattern[i] != pattern[k]) k = lps[k - 1];
            if (pattern[i] == pattern[k]) k++;
            lps[i] = k;
        }

        int matched = 0, count = 0;
        while (true) {
            int next = stream.next();
            count++;

            // On mismatch, fall back along the LPS instead of resetting to 0
            while (matched > 0 && next != pattern[matched]) {
                matched = lps[matched - 1];
            }
            if (next == pattern[matched]) matched++;

            if (matched == n) return count - n;
        }
    }
}