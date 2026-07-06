class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefix = new long[n + 1];   // long: sums can overflow int
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int res = Integer.MAX_VALUE;
        // deque holds indices of prefix[], kept in increasing order of prefix value
        java.util.Deque<Integer> deque = new java.util.ArrayDeque<>();

        for (int j = 0; j <= n; j++) {
            // shrink from front: if prefix[j] - prefix[front] >= k, we found a valid window.
            // since we want the SHORTEST, take it and pop the front (it can't help a later j better)
            while (!deque.isEmpty() && prefix[j] - prefix[deque.peekFirst()] >= k) {
                res = Math.min(res, j - deque.pollFirst());
            }
            // maintain monotonic increasing prefix values: pop backs that are >= prefix[j],
            // because a later index with a smaller-or-equal prefix is always a better start
            while (!deque.isEmpty() && prefix[deque.peekLast()] >= prefix[j]) {
                deque.pollLast();
            }
            deque.offerLast(j);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}