class Solution {
    public boolean isValid(String s) {
        Stack<Character> tracker = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                tracker.push(c);
            }
            if (c == ')' || c == ']' || c == '}') {
                if (tracker.isEmpty() || !isPair(tracker.pop(), c)) {
                    return false;
                }
            }
        }
        return tracker.isEmpty();
    }

    private boolean isPair(char open, char close) {
        return (
            (open == '(' && close == ')') || 
            (open == '[' && close == ']') || 
            (open == '{' && close == '}')
        );
    }
}