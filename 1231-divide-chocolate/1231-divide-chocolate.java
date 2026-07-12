class Solution {
    public int maximizeSweetness(int[] sweetness, int k) {
        int lo = 0, hi = 0;
        for (int s : sweetness) {
            lo = Math.min(lo, s);
            hi += s;
        }

        int answer = lo;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (f(sweetness, mid) >= k + 1) {
                answer = mid;
                lo = mid + 1;
            } else hi = mid - 1;
        }
        return answer;
    }

    private int f(int[] sweetness, int k) {
        int count = 0, current = 0;
        for (int s : sweetness) {
            current += s;
            if (current >= k) {
                count++;
                current = 0;
            }
        }

        return count;
    }
}