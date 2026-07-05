class Solution {
    public int numFriendRequests(int[] ages) {
        java.util.Arrays.sort(ages);
        int n = ages.length, requests = 0;

        for (int i = 0; i < n; i++) {
            int x = ages[i];

            // valid y: lower < y <= x, where lower = 0.5*x + 7
            // lowerBound: first index whose age is strictly greater than (x/2 + 7)
            int left = upperBound(ages, x / 2 + 7);
            // upperBound for x: first index whose age is strictly greater than x
            int right = upperBound(ages, x);

            // people in [left, right) are valid targets; exclude x himself (1 self in that range)
            int inRange = right - left;
            if (inRange > 1) {              // must be >1, else only self qualifies -> 0 requests
                requests += inRange - 1;    // subtract the requester's own slot
            }
        }
        return requests;
    }

    // first index whose value is strictly greater than target
    private int upperBound(int[] arr, int target) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] <= target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}