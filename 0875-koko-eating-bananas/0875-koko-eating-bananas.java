class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1, hi = 0;
        for (int p : piles) hi = Math.max(hi, p);

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (feaseable(piles, mid) <= h) {
                hi = mid - 1;
            } else lo = mid + 1;
        }
        return lo;
    }

    // how many hours will it take to each "piles" with "mid" speed;
    private long feaseable(int[] piles, int mid) {
        long hours = 0;
        for (int p : piles) {
            hours += p / mid;
            if (p % mid > 0) hours++;
        }

        return hours;
    }
}