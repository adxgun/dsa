class Solution {
    public int specialArrayA(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < 1000; i++) {
            int count = 0;
            for (int x : nums) if (x >= i) count++;

            if (count == i) return count;
        }
        return -1;
    }

    public int specialArray(int[] nums) {
        int n = nums.length;
        int N = 1000;
        Arrays.sort(nums);
        for (int i = 0; i < N; i++) {
            int ub = upperBound(nums, i);
            System.out.println("ub -> " + ub);
            if (n - ub == i) return i;
        }
        return -1;
    }

    private int upperBound(int[] arr, int val) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] < val) lo = mid + 1;
            else hi = mid - 1;
        }
        return lo;
    }
}