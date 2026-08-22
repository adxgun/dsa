class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        // pid = process id
        // parent id of pid[i] = ppid[i]
        // graph(p) -> child

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < pid.size(); i++) {
            int parent = ppid.get(i);
            int child = pid.get(i);
            graph.computeIfAbsent(parent, (k) -> new ArrayList<>()).add(child);
        }

        List<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(kill);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            res.add(current);

            List<Integer> nei = graph.get(current);
            if (nei != null) {
                for (int next : nei) {
                    queue.offer(next);
                }
            }
        }

        return res;
    }
}