class Solution {
    public int maxDistance(int[] position, int m) {
        java.util.Arrays.sort(position);   // required: place balls left to right
        int n = position.length;

        int lo = 1, hi = position[n - 1] - position[0];   // min gap 1, max gap = full span
        int answer = 0;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;      // candidate minimum force
            if (canPlace(position, m, mid)) {
                answer = mid;                   // achievable -> try a larger gap
                lo = mid + 1;
            } else {
                hi = mid - 1;                   // too greedy -> settle for a smaller gap
            }
        }
        return answer;
    }

    // can we place m balls with every adjacent pair at least `gap` apart?
    private boolean canPlace(int[] position, int m, int gap) {
        int count = 1;                 // place the first ball in the leftmost basket
        int lastPos = position[0];
        for (int i = 1; i < position.length; i++) {
            if (position[i] - lastPos >= gap) {
                count++;               // this basket is far enough -> place a ball
                lastPos = position[i];
                if (count == m) return true;   // placed all m -> success
            }
        }
        return count >= m;
    }
}