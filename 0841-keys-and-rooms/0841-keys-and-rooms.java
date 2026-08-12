class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.offer(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int room = q.poll();
            for (int next : rooms.get(room)) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }

        for (boolean v : visited) if (!v) return false;
        return true;
    }
}