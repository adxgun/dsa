class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> merged = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            if (merged.isEmpty() || merged.getLast()[1] < intervals[i][0]) {
                merged.add(intervals[i]);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], intervals[i][1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}