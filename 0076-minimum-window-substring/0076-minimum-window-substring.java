class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] need = new int[128];
        int required = 0;
        for (char c : t.toCharArray()) {
            if (need[c] == 0) required++;
            need[c]++;
        }

        int[] have = new int[128];
        int bestLen = Integer.MAX_VALUE, start = 0, formed = 0, left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            have[c]++;

            if (need[c] == have[c]) formed++;
            while (required == formed) {
                if (right - left + 1 < bestLen) {
                    bestLen = right - left + 1;
                    start = left;
                }

                char lc = s.charAt(left);
                have[lc]--;
                if (have[lc] < need[lc]) formed--;
                left++;
            }
        }

        return bestLen == Integer.MAX_VALUE ? "" : s.substring(start, start + bestLen);
    }
}