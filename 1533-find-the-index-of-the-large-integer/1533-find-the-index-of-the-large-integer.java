/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     // Compares the sum of arr[l..r] with the sum of arr[x..y] 
 *     // return 1 if sum(arr[l..r]) > sum(arr[x..y])
 *     // return 0 if sum(arr[l..r]) == sum(arr[x..y])
 *     // return -1 if sum(arr[l..r]) < sum(arr[x..y])
 *     public int compareSub(int l, int r, int x, int y) {}
 *
 *     // Returns the length of the array
 *     public int length() {}
 * }
 */

class Solution {
    public int getIndex(ArrayReader reader) {
        int lo = 0, hi = reader.length() - 1;
        
        while (lo < hi) {
            int len = hi - lo + 1;
            int half = len / 2;
            int mid = lo + half - 1;

            if (len % 2 == 0) {
                int cmp = reader.compareSub(lo, mid, mid + 1, hi);
                if (cmp < 0) lo = mid + 1;
                else hi = mid;
            } else {
                int cmp = reader.compareSub(lo, mid, mid + 1, hi - 1);
                if (cmp == 0) return hi;
                else if (cmp < 0) lo = mid + 1;
                else hi = mid;
            }
        }
        return lo;
    }
}