class Solution {
    public int calculateTime(String keyboard, String word) {
        int[] pos = new int[26];
        for (int i = 0; i < keyboard.length(); i++) {
            pos[keyboard.charAt(i) - 'a'] = i;
        }

        int total = 0, start = 0;
        for (char c : word.toCharArray()) {
            int current = pos[c - 'a'];
            total += Math.abs(start - current);
            start = current;
        }
        return total;
    }
}