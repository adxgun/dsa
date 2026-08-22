class Solution {
    private static final int[][] DIRECTIONS = {
        {0, 1}, {-1, -1}, {-1, 0}, {0, -1},
        {1, 0}, {1, 1}, {1, -1}, {-1, 1}
    };
    public char[][] updateBoard(char[][] board, int[] click) {
        int startRow = click[0], startCol = click[1];
        if (board[startRow][startCol] == 'M') {
            board[startRow][startCol] = 'X';
            return board;
        }

        int rows = board.length;
        int cols = board[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startRow, startCol});

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], col = cell[1];

            if (board[row][col] != 'E') continue;

            int adjacentMines = countAdjacentMines(board, row, col, rows, cols);
            if (adjacentMines > 0) {
                board[row][col] = ((char) ('0' + adjacentMines));
                continue;
            }

            board[row][col] = 'B';
            for (int[] dir : DIRECTIONS) {
                int nr = row + dir[0], nc = col + dir[1];
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && board[nr][nc] == 'E') {
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
        return board;
    }

    private int countAdjacentMines(char[][] board, int row, int col, int rows, int cols) {
        int count = 0;
        for (int[] dir : DIRECTIONS) {
            int nr = row + dir[0];
            int nc = col + dir[1];

            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && board[nr][nc] == 'M') {
                count++;
            }
        }
        return count;
    }
}