class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length, left = 0, right = n - 1, hidx = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int papers = n - mid;
            if (citations[mid] >= papers) {
                hidx = papers;
                right = mid - 1;
            } else left = mid + 1;
        }
        return hidx;
    }
}