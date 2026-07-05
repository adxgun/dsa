class Solution {
    public int reachNumber(int target) {
        long t = Math.abs((long) target);

        // Binary search: smallest n with n(n+1)/2 >= t
        long lo = 0, hi = 2_000_000;   // hi large enough that hi(hi+1)/2 >> any int target
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (mid * (mid + 1) / 2 >= t) hi = mid;
            else lo = mid + 1;
        }
        long n = lo;

        // Parity fix: need (sum - t) even; at most two more steps
        while ((n * (n + 1) / 2 - t) % 2 != 0) {
            n++;
        }
        return (int) n;
    }
}