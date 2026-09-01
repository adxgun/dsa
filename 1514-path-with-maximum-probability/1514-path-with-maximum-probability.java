class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<double[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int u = edge[0], v = edge[1];
            double p = succProb[i];
            graph.get(u).add(new double[]{v, p});
            graph.get(v).add(new double[]{u, p});
        }

        PriorityQueue<double[]> queue = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        queue.offer(new double[]{start_node, 1.0});
        double[] probs = new double[n];
        probs[start_node] = 1.0;

        while (!queue.isEmpty()) {
            double[] top = queue.poll();
            int node = (int) top[0];
            double prob = top[1];
            if (node == end_node) return prob;
            if (prob < probs[node]) continue;

            for (double[] edge : graph.get(node)) {
                int next = (int) edge[0];
                double newProb = edge[1] * probs[node];

                if (newProb > probs[next]) {
                    probs[next] = newProb;
                    queue.offer(new double[]{next, newProb});
                }
            }
        }

        return 0.0;
    }
}