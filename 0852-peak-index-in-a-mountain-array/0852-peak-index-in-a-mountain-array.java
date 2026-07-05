class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int max = 0, idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                idx = i;
            }
        }
        return idx;
    }
}