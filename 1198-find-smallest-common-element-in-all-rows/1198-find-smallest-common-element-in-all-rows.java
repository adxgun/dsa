class Solution {
    public int smallestCommonElement(int[][] mat) {
        if (mat.length == 0) return -1;

        int[] m = mat[0];
        for (int x : m) {
            boolean inAll = true;
            for (int i = 1; i < mat.length; i++) {
                if (!search(mat[i], x)) {
                    inAll = false;
                    continue;
                }
            }

            if (inAll) return x;
        }

        return -1;
    }

    private boolean search(int[] nums, int t) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == t) return true;
            else if (nums[mid] < t) lo = mid + 1;
            else hi = mid - 1;
        }
        return false;
    }
}