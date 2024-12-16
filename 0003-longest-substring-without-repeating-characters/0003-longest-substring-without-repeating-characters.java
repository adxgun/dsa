class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLength = 0;
        Set<Character> charSet = new HashSet<>();

        // bbbbb
        // [b] -> [b] -> [b]
        // right = 0, 1, 2
        // left = 0, 1, 2
        // length = 1, 2, 

        for (int right = 0; right < s.length(); right++) {
            while(charSet.contains(s.charAt(right))) {
                charSet.remove(s.charAt(left));
                left++;
            }

            charSet.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}