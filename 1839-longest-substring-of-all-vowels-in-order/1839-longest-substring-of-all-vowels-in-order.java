class Solution {
    public int longestBeautifulSubstring(String word) {
        if (word.length() < 5) return 0;

        int left = 0, distint = 1, maxLen = 0;
        for (int right = 1; right < word.length(); right++) {
            char prev = word.charAt(right - 1);
            char current = word.charAt(right);
            if (prev < current) {
                distint++;
            } else if (prev > current) {
                left = right;
                distint = 1;
            }

            if (distint == 5)
                maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}