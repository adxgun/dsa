class Solution {
    public int numSquares(int n) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(n);
        visited.add(n);

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level += 1;

            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                for (int sq = 1; sq * sq <= node; sq++) {
                    int next = node - sq * sq;
                    if (next == 0) return level;

                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }
        }
        return level;
    }
}