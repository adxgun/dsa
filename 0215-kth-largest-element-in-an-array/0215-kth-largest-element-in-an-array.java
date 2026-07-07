class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for (int x : nums) q.offer(x);

        while (k > 1) {
            q.poll();
            k--;
        }
        return q.poll();
    }
}