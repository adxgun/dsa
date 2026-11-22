class Solution {
    public boolean checkString(String s) {
        boolean appears = false;
        for (char c : s.toCharArray()) {
            if (c == 'b') appears = true;
            if (c == 'a' && appears) return false;
        }

        return true;
    }
}