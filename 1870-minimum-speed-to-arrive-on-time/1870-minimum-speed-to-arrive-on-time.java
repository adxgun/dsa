class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;
        if (hour <= n - 1) return -1;
        
        int lo = 1, hi = 10_000_000;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (timeNeeded(dist, mid) <= hour) hi = mid - 1;
            else lo = mid + 1;
        }

        return lo;
    }

    private double timeNeeded(int[] dist, int speed) {
        double time = 0;
        int n = dist.length;

        for (int i = 0; i < n - 1; i++) {
            time += (dist[i] + speed - 1) / speed;
        }

        time += (double) dist[n - 1] / speed;
        return time;
    }
}