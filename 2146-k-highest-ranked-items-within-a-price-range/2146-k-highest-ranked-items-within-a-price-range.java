class Solution {
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        int startPrice = pricing[0], endPrice = pricing[1];
        // distance, price, row, col
        PriorityQueue<int[]> resultPQ = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            if (a[1] != b[1]) return a[1] - b[1];
            if (a[2] != b[2]) return a[2] - b[2];
            if (a[3] != b[3]) return a[3] - b[3];
            return a[0] - b[0];
        });

        // row, col, distance
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[rows][cols];
        queue.offer(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;

        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], col = cell[1], distance = cell[2];
            int price = grid[row][col];
            if (price >= startPrice && price <= endPrice) {
                resultPQ.offer(new int[]{distance, price, row, col});
            }

            for (int[] dir : directions) {
                int nr = dir[0] + row, nc = dir[1] + col;
                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols || visited[nr][nc]) continue;
                if (grid[nr][nc] == 0) continue;

                visited[nr][nc] = true;
                queue.offer(new int[]{nr, nc, distance + 1});
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        while (!resultPQ.isEmpty()) {
            int[] node = resultPQ.poll();
            result.add(Arrays.asList(node[2], node[3]));
            if (result.size() == k) break;
        }

        return result;
    }
}