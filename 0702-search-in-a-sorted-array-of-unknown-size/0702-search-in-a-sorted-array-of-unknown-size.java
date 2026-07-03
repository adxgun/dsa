/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int lo = 0, hi = 1;

        while (reader.get(hi) < target) {
            lo = hi;
            hi *= 2;
        }

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int val = reader.get(mid);
            if (val == target) return mid;
            else if (val < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }
}