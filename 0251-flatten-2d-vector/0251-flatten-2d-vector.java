class Vector2D {

    private int row = 0, col = 0;
    private int[][] vec;
    public Vector2D(int[][] vec) {
        this.vec = vec;
    }
    
    public int next() {
        hasNext();
        int result = vec[row][col];
        col++;
        return result;
    }
    
    public boolean hasNext() {
        while (row < vec.length && col >= vec[row].length) {
            row++;
            col = 0;
        }
        return row < vec.length;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */