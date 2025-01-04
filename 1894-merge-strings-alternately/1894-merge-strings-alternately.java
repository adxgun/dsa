class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0, l1 = word1.length(), l2 = word2.length();

        while(i < l1 || j < l2) {
            if (i < l1) {
                sb.append(word1.charAt(i));
                i++;
            }

            if (j < l2) {
                sb.append(word2.charAt(j));
                j++;
            }
        }

        return sb.toString();
    }
}