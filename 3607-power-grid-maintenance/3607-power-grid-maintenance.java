class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] conn : connections) {
            int u = conn[0], v = conn[1];
            // graph.computeIfAbsent(u, (k) -> new ArrayList<>()).add(u);
            graph.computeIfAbsent(u, (k) -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, (k) -> new ArrayList<>()).add(u);
        }

        int[] comp = new int[c + 1];
        Arrays.fill(comp, -1);
        List<PriorityQueue<Integer>> heaps = new ArrayList<>();
        for (int i = 1; i <= c; i++) {
            if (comp[i] == -1) {
                heaps.add(bfs(graph, comp, i, heaps.size()));
            }
        }

        List<Integer> res = new ArrayList<>();
        boolean[] stationState = new boolean[c + 1];
        Arrays.fill(stationState, true);
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int station = query[1];
            if (query[0] == 2) {
                stationState[station] = false;
                continue;
            }
            
            if (stationState[station]) {
                res.add(station);
                continue;
            }

            PriorityQueue<Integer> heap = heaps.get(comp[station]);
            while (!heap.isEmpty() && !stationState[heap.peek()]) heap.poll();
            res.add(heap.isEmpty() ? -1 : heap.peek());
        }

        int n = res.size();
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) answer[i] = res.get(i);
        return answer;
    }

    private PriorityQueue<Integer> bfs(
        Map<Integer, List<Integer>> graph, 
        int[] comp, 
        int station,
        int id) {
        
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(station);
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        comp[station] = id;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            heap.offer(node);
            
            for (int next : graph.getOrDefault(node, Collections.emptyList())) {
                if (comp[next] == -1) {
                    comp[next] = id;
                    queue.offer(next);
                }
            }
        }

        return heap;
    }
}