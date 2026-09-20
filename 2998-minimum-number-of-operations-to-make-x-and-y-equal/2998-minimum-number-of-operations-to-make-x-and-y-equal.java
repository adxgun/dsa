class Solution {
    public int minimumOperationsToMakeEqual(int x, int y) {
        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(x);
        visited.add(x);

        int ops = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                if (cur == y) return ops;
                
                List<Integer> next = new ArrayList<>();
                if ((cur * cur) % 11 == 0) next.add(cur / 11);
                if ((cur * cur) % 5 == 0) next.add(cur / 5);
                next.add(cur - 1);
                next.add(cur + 1);
                for (int node : next) {
                    if (!visited.contains(node)) {
                        visited.add(node);
                        queue.offer(node);
                    }
                }
            }
            ops += 1;
        }
        return ops;
    }
}