class Solution {
    public int findTheDistanceValueA(int[] arr1, int[] arr2, int d) {
        int count = 0;
        for (int x : arr1) {
            boolean all = true;
            for (int y : arr2) {
                if (Math.abs(y - x) <= d) {
                    all = false;
                    break;
                }
            }

            if (all) count += 1;
        }
        return count;
    }

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        java.util.Arrays.sort(arr2);
        int count = 0;
        for (int x : arr1) {
            // find first arr2 element >= x - d; if it's <= x + d, x is within d of something
            int idx = lowerBound(arr2, x - d);
            if (idx == arr2.length || arr2[idx] > x + d) {
                count++;   // nothing in [x-d, x+d] -> x qualifies
            }
        }
        return count;
    }

    private int lowerBound(int[] arr, int target) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] < target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}