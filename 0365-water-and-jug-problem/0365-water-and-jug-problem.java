class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        if (target > x + y) return false;

        Set<String> visited = new HashSet<>();
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        visited.add(0 + "," + 0);

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int a = cur[0], b = cur[1];

            if (a + b == target) return true;

            List<int[]> nextStates = new ArrayList<>();
            nextStates.add(new int[]{x, b}); // fill with water
            nextStates.add(new int[]{a, y}); // fill with water
            nextStates.add(new int[]{0, b});
            nextStates.add(new int[]{a, 0});

            int pourXinY = Math.min(a, y - b);
            nextStates.add(new int[]{a - pourXinY, b + pourXinY});

            int pourYinX = Math.min(b, x - a);
            nextStates.add(new int[]{a + pourYinX, b - pourYinX});

            for (int[] state : nextStates) {
                String serialized = state[0] + "," + state[1];
                if (!visited.contains(serialized)) {
                    visited.add(serialized);
                    queue.offer(state);
                }
            }
        }

        return false;
    }
}