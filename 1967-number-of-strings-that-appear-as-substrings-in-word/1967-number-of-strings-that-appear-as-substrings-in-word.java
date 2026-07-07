class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int c = 0;
        for (String pattern : patterns) {
            if (word.contains(pattern)) c++;
        }
        return c;
    }
}