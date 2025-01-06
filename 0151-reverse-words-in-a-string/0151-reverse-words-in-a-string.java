class Solution {
    public String reverseWords(String s) {
        if (s == null) {
            return "";
        }

        s = s.trim();
        String[] words = s.split("\\s+");

        List<String> l = Arrays.asList(words);
        Collections.reverse(l);

        return String.join(" ", l);
    }
}