class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == k) return nums;

        Map<Integer, Integer> freq = new HashMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>(
            (a, b) -> freq.get(a) - freq.get(b));

        for (int x : nums) {
            freq.merge(x, 1, Integer::sum);
        }

        for (int n : freq.keySet()) {
            heap.offer(n);
            if (heap.size() > k) heap.poll();
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) res[i] = heap.poll();
        return res;
    }
}