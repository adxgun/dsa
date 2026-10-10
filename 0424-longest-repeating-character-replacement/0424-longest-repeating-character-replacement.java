class Solution {
    public int characterReplacement(String s, int k) {
        int best = 0, left = 0, maxFreq = 0;
        int[] count = new int[26];

        for (int right = 0; right < s.length(); right++) {
            int letter = s.charAt(right) - 'A';
            count[letter]++;
            maxFreq = Math.max(maxFreq, count[letter]);

            int windowLen = right - left + 1;
            int change = windowLen - maxFreq;

            if (change > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            best = Math.max(best, right - left + 1);
        }

        return best;
    }
}