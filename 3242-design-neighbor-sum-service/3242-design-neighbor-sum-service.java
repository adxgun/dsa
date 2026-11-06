class NeighborSum {

    private final Map<String, Integer> sums = new HashMap<>();
    private static final int[][] ADJ = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static final int[][] DIAG = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public NeighborSum(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int adjSum = 0, diagSum = 0;
                for (int[] dir : ADJ) {
                    int nr = dir[0] + r, nc = dir[1] + c;
                    if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;

                    adjSum += grid[nr][nc];
                }

                for (int[] dir : DIAG) {
                    int nr = dir[0] + r, nc = dir[1] + c;
                    if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;

                    diagSum += grid[nr][nc];
                }

                sums.put(grid[r][c] + ":adj", adjSum);
                sums.put(grid[r][c] + ":diag", diagSum);
            }
        }    
    }
    
    public int adjacentSum(int value) {
        return sums.get(value + ":adj");
    }
    
    public int diagonalSum(int value) {
        return sums.get(value + ":diag");
    }
}

/**
 * Your NeighborSum object will be instantiated and called as such:
 * NeighborSum obj = new NeighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */