class Solution {
    public int maxLength(int[] ribbons, int k) {
        int lo = 1, hi = 0;
        for (int x : ribbons) hi = Math.max(x, hi);

        int answer = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (feaseable(ribbons, k, mid)) {
                answer = mid;
                lo = mid + 1;
            }
            else hi = mid - 1;
        }
        return answer;
    }

    private boolean feaseable(int[] ribbons, int k, int mid) {
        long pieces = 0;
        for (int r : ribbons) {
            pieces += (r / mid);
            if (pieces >= k) return true;
        }

        return pieces >= k;
    }
}