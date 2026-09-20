class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int rows = grid.length, cols = grid[0].length, n = queries.length;
        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) order[i] = i;
        Arrays.sort(order, (a, b) -> Integer.compare(queries[a], queries[b]));

        int[] answer = new int[n];
        boolean[][] visited = new boolean[rows][cols];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;
        
        int points = 0;
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        
        for (int qi : order) {
            int query = queries[qi];

            while (!pq.isEmpty() && pq.peek()[0] < query) {
                int[] node = pq.poll();
                int row = node[1], col = node[2];
                points++;

                for (int[] dir : directions) {
                    int nr = dir[0] + row, nc = dir[1] + col;
                    if (nr < 0 || nr >= rows || nc < 0 || nc >= cols || visited[nr][nc]) continue;

                    pq.offer(new int[]{grid[nr][nc], nr, nc});
                    visited[nr][nc] = true;
                }
            }

            answer[qi] = points;
        }

        return answer;
    }
}