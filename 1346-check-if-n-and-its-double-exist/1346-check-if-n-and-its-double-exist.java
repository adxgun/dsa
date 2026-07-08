class Solution {
    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            int idx = search(arr, arr[i] * 2);
            if (idx != -1 && i != idx) return true;
        }
        
        return false;
    }

    int search(int[] arr, int t) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == t) return mid;
            else if (arr[mid] < t) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }
}
// 2,3,5,10