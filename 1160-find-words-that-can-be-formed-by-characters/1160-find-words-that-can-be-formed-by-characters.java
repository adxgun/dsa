class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] charsFreq = new int[26];
        for (char c : chars.toCharArray()) {
            charsFreq[c - 'a']++;
        }

        int total = 0;
        for (String word : words) {
            boolean formed = true;
            int[] copy = charsFreq.clone();
            for (int i = 0; i < word.length(); i++) {
                int c = word.charAt(i) - 'a';
                if (copy[c] == 0) formed = false;
                else copy[c]--;
            }

            if (formed) total += word.length();
        }

        return total;
    }
}