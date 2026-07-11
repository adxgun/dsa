class Solution {
    public int[] closestRoom(int[][] rooms, int[][] queries) {
        int n = rooms.length, k = queries.length;
        // sort rooms by size descending
        Arrays.sort(rooms, (a, b) -> b[1] - a[1]);

        Integer[] queryOrder = new Integer[k];
        for (int i = 0; i < k; i++) queryOrder[i] = i;
        // sort query indices by minSize descending (keep original index for output placement)
        Arrays.sort(queryOrder, (a, b) -> queries[b][1] - queries[a][1]);

        int[] answer = new int[k];
        TreeSet<Integer> set = new TreeSet<>();
        int roomPtr = 0;
        for (int qi : queryOrder) {
            int preferred = queries[qi][0], minSize = queries[qi][1];

            while (roomPtr < n && rooms[roomPtr][1] >= minSize) {
                set.add(rooms[roomPtr][0]);
                roomPtr++;
            }

            Integer floor = set.floor(preferred);
            Integer ceil = set.ceiling(preferred);
            answer[qi] = pickClosest(floor, ceil, preferred);
        }

        return answer;
    }

    private int pickClosest(Integer floor, Integer ceil, int preferred) {
        if (floor == null && ceil == null) return -1;
        if (floor == null) return ceil;
        if (ceil == null) return floor;

        int floorDist = preferred - floor;
        int ceilDist = ceil - preferred;
        if (floorDist <= ceilDist) return floor;
        return ceil;
    }
}