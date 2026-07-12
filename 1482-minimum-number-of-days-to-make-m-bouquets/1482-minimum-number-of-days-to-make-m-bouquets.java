class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if ((long) m * k > n) return -1; 
        
        int lo = Integer.MAX_VALUE, hi = 0;
        for (int d : bloomDay) {
            lo = Math.min(lo, d);
            hi = Math.max(hi, d);
        }

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (f(bloomDay, m, k, mid)) hi = mid - 1;
            else lo = mid + 1;
        }
        return lo;
    }

    private boolean f(int[] bloomDays, int m, int k, int day) {
        int bouquests = 0, consecutive = 0;
        for (int bloom : bloomDays) {
            if (bloom <= day) {
                consecutive++;

                if (consecutive == k) {
                    bouquests++;
                    consecutive = 0;

                    if (bouquests >= m) return true;
                }
            } else consecutive = 0;
        }
        return bouquests >= m;
    }
}