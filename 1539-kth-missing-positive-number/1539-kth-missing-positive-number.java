class Solution {
    public int findKthPositive(int[] arr, int k) {
        int j = 1, count = 0;
        while (j >= 1) {
            int pos = findPos(arr, j);
            if (pos == -1) count++;

            if (count == k) return j;
            j++;
        }
        return -1;
    }

    private int findPos(int[] arr, int val) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == val) return mid;
            else if (arr[mid] < val) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }
}