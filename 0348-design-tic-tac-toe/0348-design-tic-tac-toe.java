class TicTacToe {

    int moves = 0;
    private int[] rows, cols;
    private int diag = 0, antiDiag = 0, n = 0;
    
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        this.n = n;
    }
    
    public int move(int row, int col, int player) {
        int delta = player == 1 ? 1 : -1;
        rows[row] += delta;
        cols[col] += delta;

        if (row == col) diag += delta;
        if (row + col == n - 1) antiDiag += delta;

        moves++;
        if (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || Math.abs(diag) == n || Math.abs(antiDiag) == n) return player;
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */