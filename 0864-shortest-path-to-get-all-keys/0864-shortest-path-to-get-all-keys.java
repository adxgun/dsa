class Solution {

    class State {
        int r, c;
        Set<Character> keys;

        public State(int r, int c, Set<Character> keys) {
            this.r = r;
            this.c = c;
            this.keys = keys;
        }

        public String key() {
            StringBuilder sb = new StringBuilder();
            sb.append(r).append(',').append(c).append(':');
            for (char c : keys) sb.append(c);
            return sb.toString();
        }
    }

    private final char EMPTY = '.', WALL = '#', START = '@';
    public int shortestPathAllKeys(String[] grid) {
        int rows = grid.length;
        int cols = grid[0].length();
        Queue<State> queue = new ArrayDeque<>();
        int allKeys = 0, startRow = 0, startCol = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                char ch = grid[r].charAt(c);
                if (ch == START) {
                    startRow = r;
                    startCol = c;
                } else if (ch >= 'a' && ch <= 'f') allKeys++;
            }
        }

        State start = new State(startRow, startCol, new TreeSet<>());
        queue.offer(start);
        Set<String> visited = new HashSet<>();
        visited.add(start.key());
        
        int moves = 0;
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                State cur = queue.poll();
                if (cur.keys.size() == allKeys) return moves;
                
                for (int[] dir : directions) {
                    int nr = dir[0] + cur.r, nc = dir[1] + cur.c;
                    if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                    
                    char ch = grid[nr].charAt(nc);
                    if (ch == WALL) continue;
                    if (ch >= 'A' && ch <= 'F' && !cur.keys.contains(Character.toLowerCase(ch))) {
                        continue;
                    }

                    Set<Character> newKeys = new HashSet<>(cur.keys);
                    if (ch >= 'a' && ch <= 'f') newKeys.add(ch);
                    
                    State newState = new State(nr, nc, newKeys);
                    String stateKey = newState.key();
                    if (!visited.contains(stateKey)) {
                        visited.add(stateKey);
                        queue.offer(newState);
                    }
                }
            }
            moves++;
        }

        return -1;
    }
}