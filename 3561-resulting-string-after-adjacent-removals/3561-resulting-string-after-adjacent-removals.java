class Solution {
    public String resultingString(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            int i = ch - 'a';
            if (!stack.isEmpty() && Math.abs(i - stack.peek()) == 1) stack.pop();
            else if (!stack.isEmpty() && Math.abs(i - stack.peek()) == 25) stack.pop();
            else stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int x : stack) sb.append((char) ('a' + x));
        
        return sb.reverse().toString();
    }
}