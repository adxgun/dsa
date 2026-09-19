class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String result = "";
        int max = 0;

        for (int i = 0; i < dictionary.size(); i++) {
            String next = dictionary.get(i);
            boolean isSubsequence = isSubsequence(s, next);
            if (isSubsequence) {
                if (next.length() > max) {
                    result = next;
                    max = next.length();
                } else if (next.length() == max && next.compareTo(result) < 0) {
                    result = next;
                }
            }
        }
        return result;
    }

    private boolean isSubsequence(String left, String right) {
        int i = 0, j = 0;
        while(i < left.length() && j < right.length()) {
            if (left.charAt(i) == right.charAt(j)) j++;
            i++;
        }
        return j == right.length();
    }
}