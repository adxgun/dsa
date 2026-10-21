class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Integer, Integer> count = new HashMap<>();
        int left = 0, len = 0;
        
        for (int right = 0; right < s.length(); right++) {
            count.merge(s.charAt(right) - 'a', 1, Integer::sum);

            while (count.size() > 2) {
                int i = s.charAt(left) - 'a';
                int rm = count.merge(i, -1, Integer::sum);
                if (rm == 0) count.remove(i);
                left++;
            }

            len = Math.max(len, right - left + 1);
        }

        return len;
    }
}