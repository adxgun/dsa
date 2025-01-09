class Solution {
    public int maxVowels(String s, int k) {
        int max = 0, count = 0, n = s.length();
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                count++;
            }
        }
        
        max = count;
        for (int i = k; i < n; i++) {
            if (isVowel(s.charAt(i - k))) {
                count--;
            }

            if (isVowel(s.charAt(i))) {
                count++;
            }

            max = Math.max(max, count);
        }
        return max;
    }

    private boolean isVowel(char c) {
        return 'a' == c || 'e' == c || 'i' == c || 'o' == c || 'u' == c;
    }
}