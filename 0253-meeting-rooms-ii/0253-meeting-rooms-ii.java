class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            if (!pq.isEmpty() && start >= pq.peek()) pq.poll();

            pq.offer(end);
        }

        return pq.size();
    }
}