class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (startsAndEndsWithVowel(words[i]) ? 1 : 0);
        }

        int[] res = new int[queries.length];
        for (int x = 0; x < queries.length; x++) {
            int l = queries[x][0], r = queries[x][1];
            res[x] = prefix[r + 1] - prefix[l];
        }

        return res;
    }

    private boolean startsAndEndsWithVowel(String s) {
        return isVowel(s.charAt(0)) && isVowel(s.charAt(s.length() - 1));
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'i' || ch == 'e' || ch == 'o' || ch == 'u';
    }
}