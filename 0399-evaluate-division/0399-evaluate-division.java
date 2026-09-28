class Solution {
    public double[] calcEquation(
        List<List<String>> equations, 
        double[] values, 
        List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> eq = equations.get(i);
            String a = eq.get(0), b = eq.get(1);
            double edge = values[i];
            graph.computeIfAbsent(a, (k) -> new HashMap<>()).put(b, edge);
            graph.computeIfAbsent(b, (k) -> new HashMap<>()).put(a, 1.0 / edge);
        }

        int size = queries.size();
        double[] result = new double[size];
        int index = 0;
        for (int i = 0; i < size; i++) {
            List<String> query = queries.get(i);
            result[i] = bfs(graph, query);
        }

        return result;
    }

    private double bfs(Map<String, Map<String, Double>> graph, List<String> query) {
        String a = query.get(0), b = query.get(1);
        if (!graph.containsKey(a) || !graph.containsKey(b)) return -1;
        if (a.equals(b)) return 1.0;
        
        Queue<String> queue = new ArrayDeque<>();
        Queue<Double> products = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        visited.add(a);
        queue.offer(a);
        products.offer(1.0);

        while (!queue.isEmpty()) {
            String node = queue.poll();
            double curProduct = products.poll();

            for (Map.Entry<String, Double> entry : graph.get(node).entrySet()) {
                String next = entry.getKey();
                if (!visited.add(next)) continue;

                double nextProd = curProduct * entry.getValue();
                if (next.equals(b)) return nextProd;

                products.offer(nextProd);
                queue.offer(next);
            }
        }

        return -1.0;
    }
}

// a/b=2; a=2b
// b/a=1/2; b=
// a->b: 2 
// b->a: 0.5
// b->c: 3
// c->b: 0.333
// a/c: 