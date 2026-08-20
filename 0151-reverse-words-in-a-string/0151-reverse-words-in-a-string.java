import java.util.StringJoiner;

class Solution {
    public String reverseWords(String s) {
        Stack<String> words = new Stack<>();
        int n = s.length(), i = 0;

        while(i < n) {
            while(i < n && s.charAt(i) == ' ') i++;

            int start = i;
            while (i < n && s.charAt(i) != ' ') i++;
            if (i > start) words.push(s.substring(start, i));
        }

        StringJoiner result = new StringJoiner(" ");
        while(!words.isEmpty()) {
            result.add(words.pop());
        }

        return result.toString();
    }

    public String reverseWords1(String s) {
        String[] words = s.trim().split("\\s+");
        int left = 0, right = words.length - 1;
        while (left < right) {
            String temp = words[right];
            words[right] = words[left].trim();
            words[left] = temp.trim();

            left++;
            right--;
        }

        StringJoiner joiner = new StringJoiner(" ");
        for (String w : words) joiner.add(w);
        return joiner.toString();
    }
}