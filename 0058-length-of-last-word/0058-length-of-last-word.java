class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int n = s.length() - 1, len = 0;

        while (n >= 0) {
            if (s.charAt(n) == ' ') break;
            len++;

            n--;
        }

        return len;
    }
}