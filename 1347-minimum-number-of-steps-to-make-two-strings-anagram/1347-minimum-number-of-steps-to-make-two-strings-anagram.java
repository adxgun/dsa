class Solution {
    public int minSteps(String s, String t) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;
        for (char c : t.toCharArray()) freq[c - 'a']--;

        int step = 0;
        for (int count : freq) {
            if (count > 0) step += count;
        }
        
        return step;
    }
}