class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int lo = 1, hi = 0;
        for (int x : nums) hi = Math.max(x, hi);

        int answer = hi;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (sum(nums, mid) <= threshold) {
                answer = mid;
                hi = mid - 1;
            } else lo = mid + 1;
        }

        return answer;
    }

    private int sum(int[] nums, int div) {
        int sum = 0;
        for (int x : nums) sum += (x + div - 1) / div;
        return sum;
    }
}