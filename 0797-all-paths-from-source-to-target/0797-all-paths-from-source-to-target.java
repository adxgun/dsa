class Solution {
    
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        traverse(graph, 0);
        return res;    
    }

    private void traverse(int[][] graph, int s) {
        path.add(s);
        int n = graph.length;
        if (s == n - 1) {
            res.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }

        for (int v : graph[s]) {
            traverse(graph, v);
        }

        path.removeLast();
    }
}