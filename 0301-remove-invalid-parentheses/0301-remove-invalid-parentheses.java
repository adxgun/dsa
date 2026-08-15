class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(s);
        visited.add(s);

        boolean found = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();

                if (isValid(cur)) {
                    result.add(cur);
                    found = true;
                }

                if (found) continue;

                for (int j = 0; j < cur.length(); j++) {
                    char ch = cur.charAt(j);
                    if (ch != '(' && ch != ')') continue;

                    String nei = cur.substring(0, j) + cur.substring(j + 1);
                    if (!visited.contains(nei)) {
                        visited.add(nei);
                        queue.offer(nei);
                    }
                }
            }

            if (found) break;
        }
        return result;
    }

    private boolean isValid(String s) {
        int balance = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') balance += 1;
            else if (c == ')') {
                balance -= 1;
                if (balance < 0) return false;
            }
        }
        return balance == 0;
    }
}