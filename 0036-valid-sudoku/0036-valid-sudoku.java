class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        Set<Character>[] rows = new HashSet[n];
        Set<Character>[] cols = new HashSet[n];
        Set<Character>[] boxes = new HashSet[n];

        for (int i = 0; i < n; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }

                int boxIndex = (i / 3) * 3 + (j / 3);

                if (rows[i].contains(c) || cols[j].contains(c) || boxes[boxIndex].contains(c)) {
                    return false;
                }

                rows[i].add(c);
                cols[j].add(c);
                boxes[boxIndex].add(c);
            }
        }
        return true;
    }
}