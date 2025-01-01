class Solution {
    public int longestValidParentheses(String s) {
        int result = 0, n = s.length();
        Stack<Integer> tracker = new Stack<>();
        tracker.push(-1);

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                tracker.push(i);
            } else {
                tracker.pop();

                if (tracker.isEmpty()) {
                    tracker.push(i);
                } else {
                    result = Math.max(result, i - tracker.peek());
                }
            }
        }

        return result;
    }
}