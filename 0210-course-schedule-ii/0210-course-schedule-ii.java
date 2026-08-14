class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());

        int[] indegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]); // pre[1] requires pre[0]
            indegree[pre[0]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        int taken = 0;
        int[] order = new int[numCourses];
        while (!queue.isEmpty()) {
            int course = queue.poll();
            order[taken++] = course;
            for (int next : graph.get(course)) {
                indegree[next]--;
                if (indegree[next] == 0) queue.offer(next);
            }
        }

        return taken == numCourses ? order : new int[0];
    }
}