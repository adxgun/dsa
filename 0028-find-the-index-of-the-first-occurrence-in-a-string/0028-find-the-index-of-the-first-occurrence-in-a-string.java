class Solution {
    public int strStr(String haystack, String needle) {
        int nHaystack = haystack.length(), nNeedle = needle.length();

        if (nNeedle == 0) {
            return -1;
        }

        for (int i = 0; i <= nHaystack - nNeedle; i++) {
            String sub = haystack.substring(i, i + nNeedle);
            if (sub.equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}