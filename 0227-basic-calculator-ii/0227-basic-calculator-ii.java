class Solution {
    public int calculate(String s) {
        int number = 0;
        char op = '+';
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            }
            
            if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {
                switch(op) {
                    case '+' -> stack.push(number);
                    case '-' -> stack.push(-number);
                    case '*' -> stack.push(stack.pop() * number);
                    case '/' -> stack.push(stack.pop() / number);
                }

                op = ch;
                number = 0;
            }
        }

        int result = 0;
        for (int x : stack) result += x;
        return result;
    }
}

// number=2
// [3,4]
// 3+4=7