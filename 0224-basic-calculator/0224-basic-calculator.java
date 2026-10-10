class Solution {
    public int calculate(String s) {
        int result = 0;
        int sign = 1;
        int number = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            } else if (c == '+' || c == '-') { // an OP encountered
                result += number * sign;
                number = 0;
                sign = (c == '+') ? 1 : -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result += number * sign;
                number = 0;
                
                int lastSign = stack.pop();
                int lastResult = stack.pop();
                result = lastResult + result * lastSign;
            }
        }

        return result + sign * number;
    }
}