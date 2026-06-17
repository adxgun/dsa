class Solution {
    public boolean isPerfectSquare(int num) {
        long lo = 1, hi = num;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            long sq = mid * mid;
            if (sq == num) return true;
            else if (sq < num) lo = mid + 1;
            else hi = mid - 1;
        }
        return false;
    }
}