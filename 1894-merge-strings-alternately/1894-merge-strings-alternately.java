class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0, l1 = word1.length(), l2 = word2.length();
        int n = Math.max(l1, l2);

        while(i < n) {
            if (i < l1) {
                sb.append(word1.charAt(i));
            }

            if (i < l2) {
                sb.append(word2.charAt(i));
            }
            i++;
        }

        return sb.toString();
    }
}