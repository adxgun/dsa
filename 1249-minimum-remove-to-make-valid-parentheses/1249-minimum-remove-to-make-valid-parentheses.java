class Solution {
    public String minRemoveToMakeValid(String s) {
        boolean[] remove = new boolean[s.length()];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push(i);
            else if (s.charAt(i) == ')') {
                if (!stack.isEmpty()) stack.pop();
                else remove[i] = true;
            }
        }

        while (!stack.isEmpty()) remove[stack.pop()] = true;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (!remove[i]) sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}