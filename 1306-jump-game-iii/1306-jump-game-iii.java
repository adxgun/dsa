class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        q.offer(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (arr[cur] == 0) return true;

            int left = cur - arr[cur];
            if (left >= 0 && !visited[left]) {
                q.offer(left);
                visited[left] = true;
            } 

            int right = cur + arr[cur];
            if (right < n && !visited[right]) {
                q.offer(right);
                visited[right] = true;
            }
        }
        return false;
    }
}