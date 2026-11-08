class Solution {
    public int[] findBuildings(int[] heights) {
        int n = heights.length;
        List<Integer> res = new ArrayList<>();
        int best = Integer.MIN_VALUE;
        for (int right = n - 1; right >= 0; right--) {
            if (heights[right] > best) {
                res.add(right);
                best = heights[right];
            }
        }

        return res.reversed().stream().mapToInt(Integer::intValue).toArray();
    }
}