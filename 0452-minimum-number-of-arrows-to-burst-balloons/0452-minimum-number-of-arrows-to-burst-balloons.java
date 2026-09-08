class Solution {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        if (n == 0) return 0;

        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 1;
        int end = points[0][1];
        
        for (int[] point : points) {
            int start = point[0];
            if (start > end) {
                count++;
                end = point[1];
            }
        }

        return count;
    }
}