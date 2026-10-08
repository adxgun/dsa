class Spreadsheet {

    private int[][] cells;
    public Spreadsheet(int rows) {
        cells = new int[rows + 1][26];
    }
    
    public void setCell(String cell, int value) {
        int[] c = parseCell(cell);
        int row = c[0], col = c[1];
        cells[row][col] = value;
    }
    
    public void resetCell(String cell) {
        int[] c = parseCell(cell);
        int row = c[0], col = c[1];
        cells[row][col] = 0;
    }
    
    public int getValue(String formula) {
        // formula = formula.replace("=", " ").trim();
        // System.out.println(formula);
        String[] parts = formula.split("\\+");
        return parseCellValue(parts[0].substring(1, parts[0].length())) + parseCellValue(parts[1]);
    }

    private int[] parseCell(String cell) {
        char col = cell.charAt(0);
        int row = Integer.parseInt(cell.substring(1, cell.length()));
        return new int[]{row, col - 'A'};
    }

    private int parseCellValue(String cell) {
        if (Character.isDigit(cell.charAt(0))) return Integer.parseInt(cell);
        int[] c = parseCell(cell);
        int row = c[0], col = c[1];
        return cells[row][col];
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */