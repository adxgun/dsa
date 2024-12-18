class Solution {
    // odd: left,right = 0,0 -> 1,1 -> 2,2 -> 3,3 -> 4,4
    // even: left,right = 0,1 -> 1,2 -> 2,3
    // ababa
    private int expandAroundCenter(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // 1 - (-1) - 1 => 2 - 1 => 1
        // 3 - (-1) - 1 => 4 - 1 => 3
        return right - left - 1;
    }

    // 2 - (3 - 1) / 2 => 2-2/2 = 0 = start
    // 2 + 3 / 3 => 5/2 = 2 = end

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int odd = expandAroundCenter(s, i, i);
            int even = expandAroundCenter(s, i, i + 1);
            int max_len = Math.max(odd, even);
            System.out.printf("Odd=%d Even %d\n", odd, even);

            if (max_len > end - start) {
                start = i - (max_len - 1) / 2; // 1 - (3 - 1) / 2 => 1 - 2 / 2 => -1/2 => 0
                end = i + max_len / 2; // 0 + 1 / 2 = 0
                System.out.printf("Start=%d End %d i=%d max_len=%d\n", start, end, i, max_len);
            }
            
        }

        return s.substring(start, end + 1);
    }
}