class Solution {

    // build a trie
    // do dfs on the trie and build the words

    private final List<String> result = new ArrayList<>();
    private final int[][] DIRS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private char[][] board;

    private final class Node {
        Node[] children = new Node[26];
        String word = null;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        Node root = new Node();
        
        for (String word : words) {
            Node cur = root;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (cur.children[i] == null) cur.children[i] = new Node();
                cur = cur.children[i];
            }
            cur.word = word;
        }

        this.board = board;
        int rows = board.length, cols = board[0].length;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dfs(r, c, root, rows, cols);
            }
        }

        return result;
    }

    private void dfs(int row, int col, Node root, int rows, int cols) {
        char ch = board[row][col];
        if (ch == '#') return;

        Node node = root.children[ch - 'a'];
        if (node == null) return;

        if (node.word != null) {
            result.add(node.word);
            node.word = null;
        }

        board[row][col] = '#';
        for (int[] dir : DIRS) {
            int nr = dir[0] + row, nc = dir[1] + col;
            if (nr < 0 || nc < 0 || nr >= rows || nc >= cols) continue;

            dfs(nr, nc, node, rows, cols);
        }
        board[row][col] = ch;

        // if (node.word == null && isEmpty(node)) {
           // root.children[ch - 'a'] = null;
        // }
    }

    private boolean isEmpty(Node node) {
        for (Node child : node.children) {
            if (child != null) return false;
        }

        return true;
    }
}