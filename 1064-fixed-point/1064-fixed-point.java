class Solution {
    public int fixedPoint(int[] arr) {
        int lo = 0, hi = arr.length - 1, answer = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == mid) {
                answer = mid;
                hi = mid - 1;
            } else if (arr[mid] < mid) lo = mid + 1;
            else hi = mid - 1;
        }
        return answer;
    }
}