class Solution {
    public String reverseWords(String s) {
        if (s == null) {
            return "";
        }

        s = s.trim();
        String[] words = s.split("\\s+");
        int left = 0, right = words.length - 1;

        while(left < right) {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }
        return String.join(" ", words);
    }
}