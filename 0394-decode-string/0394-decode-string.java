class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack();
        Stack<String> strStack = new Stack();
        StringBuilder sb = new StringBuilder();
        int num = 0;
        for (char x : s.toCharArray()) {
            if (Character.isDigit(x)) {
                num = num * 10 + (x - '0');
            } else if (x == '[') {
                numStack.push(num);
                strStack.push(sb.toString());

                sb.setLength(0);
                num = 0;
            } else if (x == ']') {
                int repeatCount = numStack.pop();
                String prev = strStack.pop();

                StringBuilder repeated = new StringBuilder();
                for (int i = 0; i < repeatCount; i++) {
                    repeated.append(sb);
                }

                sb = new StringBuilder(prev + repeated.toString());
            } else {
                sb.append(x);
            }
        }
        return sb.toString();
    }
}