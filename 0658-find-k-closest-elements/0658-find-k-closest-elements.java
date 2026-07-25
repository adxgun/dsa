import java.util.*;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // Max-heap: the "largest" (worst) candidate sits on top so we can evict it.
        // Order by distance desc; on equal distance, larger value is "worse" (evict it first).
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> {
            int da = Math.abs(a - x);
            int db = Math.abs(b - x);
            if (da != db) return db - da;   // farther one on top
            return b - a;                    // on tie, larger value on top (to prefer smaller)
        });

        for (int num : arr) {
            heap.offer(num);
            if (heap.size() > k) heap.poll(); // remove the farthest / larger-on-tie
        }

        List<Integer> res = new ArrayList<>(heap);
        Collections.sort(res); // result must be ascending
        return res;
    }
}