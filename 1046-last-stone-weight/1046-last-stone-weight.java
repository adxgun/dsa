class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder()); // max heap
        for (int x : stones) heap.offer(x);

        while (heap.size() > 1) {
            int y = heap.poll();
            int x = heap.poll();
            if (x != y) {
                y -= x;
                heap.offer(y);
            }
        }

        if (heap.size() >= 1) return heap.poll();
        return 0;
    }
}