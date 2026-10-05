class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);   // undirected: both directions
            graph.get(e[1]).add(e[0]);
        }

        // Step 1: BFS from the root to find each node's parent and a top-down order
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        int[] order = new int[n];
        int idx = 0;

        boolean[] visited = new boolean[n];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            order[idx++] = node;
            for (int next : graph.get(node)) {
                if (!visited[next]) {
                    visited[next] = true;
                    parent[next] = node;   // whoever reaches next first is its parent
                    queue.offer(next);
                }
            }
        }

        // Step 2: bottom-up, children before parents
        int[][] count = new int[n][26];   // count[node][c] = nodes labelled c in node's subtree
        int[] answer = new int[n];

        for (int k = n - 1; k >= 0; k--) {
            int node = order[k];
            int c = labels.charAt(node) - 'a';

            count[node][c]++;                          // count the node itself
            answer[node] = count[node][c];             // its children were already added in

            if (parent[node] != -1) {
                for (int letter = 0; letter < 26; letter++) {
                    count[parent[node]][letter] += count[node][letter];   // pass totals up
                }
            }
        }
        return answer;
    }
}