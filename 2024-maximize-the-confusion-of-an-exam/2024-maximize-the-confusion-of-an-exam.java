class Solution {
    public int maxConsecutiveAnswersA(String answerKey, int k) {
        int left = longestSubContainingC(answerKey, 'T', k);
        int right = longestSubContainingC(answerKey, 'F', k);
        return Math.max(left, right);
    }

    public int maxConsecutiveAnswers(String answerKey, int k) {
        int countT = 0, countF = 0, left = 0, max = 0;
        for (int right = 0; right < answerKey.length(); right++) {
            if (answerKey.charAt(right) == 'T') countT++;
            else countF++;

            while (Math.min(countT, countF) > k) {
                if (answerKey.charAt(left) == 'T') countT--;
                else countF--;
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
    return max;
}

    private int longestSubContainingC(String s, char c, int k) {
        int count = 0, left = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) count++;
            
            while(count > k) {
                if (s.charAt(left) == c) count--;
                left++;
            }

            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}