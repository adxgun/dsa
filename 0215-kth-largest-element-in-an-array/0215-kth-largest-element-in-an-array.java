class Solution {
    public int findKthLargestA(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for (int x : nums) q.offer(x);

        while (k > 1) {
            q.poll();
            k--;
        }
        return q.poll();
    }

    public int findKthLargest(int[] nums, int k) {
        // min-heap holding the k largest elements seen so far
        PriorityQueue<Integer> q = new PriorityQueue<>();   // natural order = min-heap
        for (int x : nums) {
            q.offer(x);
            if (q.size() > k) {
                q.poll();      // evict the smallest -> heap keeps the k largest
            }
        }
        return q.peek();       // root of a size-k min-heap = k-th largest overall
    }
}