class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return image;

        int startColor = image[sr][sc];
        int rows = image.length;
        int cols = image[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{sr, sc});
        image[sr][sc] = color;

        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], col = cell[1];

            for (int[] dir : directions) {
                int nr = row + dir[0], nc = col + dir[1];

                if (nr >= 0 && nr < rows && 
                    nc >= 0 && nc < cols && 
                    image[nr][nc] == startColor) {
                        image[nr][nc] = color;
                        queue.offer(new int[]{nr, nc});
                }
            }
        }

        return image;
    }
}