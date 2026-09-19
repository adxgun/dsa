class Solution {
    public boolean checkInclusionA(String s1, String s2) {
        int i = 0, n = s1.length();
        while(i + n <= s2.length()) {
            String sub = s2.substring(i, i + n);
            boolean hasPermutation = hasPermutation(sub, s1);
            if (hasPermutation) return true;
            i++;
        }
        return false;
    }

    private boolean hasPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int[] freq = new int[26];
        for (char c : s1.toCharArray()) freq[c - 'a']++;
        for (char b : s2.toCharArray()) freq[b - 'a']--;

        for (int n : freq) if (n != 0) return false;
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1Freq = new int[26];
        int[] wFreq = new int[26];

        for (char c : s1.toCharArray()) s1Freq[c - 'a']++;

        for (int right = 0; right < s2.length(); right++) {
            // add right char
            wFreq[s2.charAt(right) - 'a']++;

            // remove left char once window exceeds s1 length
            if (right >= s1.length())
                wFreq[s2.charAt(right - s1.length()) - 'a']--;

            // just compare the two arrays
            if (Arrays.equals(s1Freq, wFreq)) return true;
        }
        return false;
    }
}
