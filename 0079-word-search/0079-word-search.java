class Solution {

    private final int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    public boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (dfs(board, r, c, word, 0)) return true;
            }
        }
        
        return false;
    }

    private boolean dfs(char[][] board, int row, int col, String word, int pos) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) return false;
        if (board[row][col] != word.charAt(pos)) return false;
        if (pos == word.length() - 1) return true;
        
        char ch = board[row][col];
        board[row][col] = '#';

        for (int[] dir : directions) {
            int nr = dir[0] + row, nc = dir[1] + col;
            if (dfs(board, nr, nc, word, pos + 1)) {
                board[row][col] = ch;
                return true;
            }
        }

        board[row][col] = ch;
        return false;
    }
}