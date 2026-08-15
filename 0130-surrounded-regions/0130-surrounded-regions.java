class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] DIR = {
            {0, -1}, {1, 0}, {0, 1}, {-1, 0},
        };
        // [1,0], [-1, 0], [0, 1], [0, -1]

        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') queue.offer(new int[]{i, 0});
            if (board[i][n - 1] == 'O') queue.offer(new int[]{i, n - 1});
        }

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') queue.offer(new int[]{0, j});
            if (board[m - 1][j] == 'O') queue.offer(new int[]{m - 1, j});
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int row = cur[0], col = cur[1];
                if (row < 0 || row >= m || col < 0 || col >= n || board[row][col] != 'O') {
                    continue;
                }
                    
                board[row][col] = '#';
                for (int[] dir : DIR) {
                    queue.offer(new int[]{dir[0] + row, dir[1] + col});
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }
}