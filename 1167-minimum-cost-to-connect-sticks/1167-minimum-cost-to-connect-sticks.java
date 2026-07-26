class Solution {
    public int connectSticks(int[] sticks) {
        if (sticks.length <= 1) return 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int x : sticks) heap.offer(x);
        
        int min = 0;
        while (heap.size() > 1) {
            int combined = heap.poll() + heap.poll();
            min += combined;
            heap.offer(combined);
        }

        return min;
    }
}

// 2,3,4
// 2+3=5 -> 5,4
// 5+4=9 -> 9
// min=5+9