class Solution {
    public int arrangeCoins(int n) {
        long lo = 0, hi = n;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            long coins = mid * (mid + 1) / 2;
            if (coins == n) return (int) mid;
            if (coins < n) lo = mid + 1;
            else hi = mid - 1;
        }
        return (int) hi;  // hi is the largest k with k(k+1)/2 <= n
    }
}