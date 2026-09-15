class Solution {

    class State {
        int row, col;
        int[] prevCell;

        public State(int row, int col, int[] prevCell) {
            this.row = row;
            this.col = col;
            this.prevCell = prevCell;
        }
    }

    public boolean containsCycle(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<State> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[rows][cols];
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (visited[r][c]) continue;
                if (bfs(grid, r, c, rows, cols, visited)) return true;
            }
        }

        return false;
    }

    private boolean bfs(char[][] grid, int row, int col, int rows, int cols, boolean[][] visited) {
        State state = new State(row, col, new int[]{-1, -1});
        Queue<State> queue = new ArrayDeque<>();
        queue.offer(state);
        visited[row][col] = true;

        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        char val = grid[row][col];

        while (!queue.isEmpty()) {
            State cur = queue.poll();

            for (int[] dir : directions) {
                int nr = dir[0] + cur.row, nc = dir[1] + cur.col;

                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                if (grid[nr][nc] != val) continue;
                if (cur.prevCell[0] == nr && cur.prevCell[1] == nc) continue;
                if (visited[nr][nc]) return true;

                State newState = new State(nr, nc, new int[]{cur.row, cur.col});
                visited[nr][nc] = true;
                queue.offer(newState);
            }
        }

        return false;
    }
}