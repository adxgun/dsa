class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        if (visited.contains("0000")) return -1;

        Queue<String> queue = new ArrayDeque<>();
        queue.offer("0000");
        visited.add("0000");

        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(target)) return step;

                for (String next : neighbours(cur)) {
                    if (!visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private List<String> neighbours(String s) {
        List<String> neighbours = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            neighbours.add(plusOne(s, i));
            neighbours.add(minusOne(s, i));
        }
        return neighbours;
    }

    private String plusOne(String s, int j) {
        char[] chars = s.toCharArray();
        chars[j] = (chars[j] == '9') ? '0' : (char) (chars[j] + 1);
        return new String(chars);
    }

    private String minusOne(String s, int j) {
        char[] chars = s.toCharArray();
        chars[j] = (chars[j] == '0') ? '9' : (char) (chars[j] - 1);
        return new String(chars);
    }
}