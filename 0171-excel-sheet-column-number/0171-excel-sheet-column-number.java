class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        for (char c : columnTitle.toCharArray()) {
            result = result * 26 + (c - 'A' + 1);   // shift left one place, add this letter's value
        }
        return result;
    }
}