class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> res = new ArrayList<>();
        
        for (int x : arr1) {
            boolean inAll = true;
            if (!search(arr2, x) || !search(arr3, x)) {
                inAll = false;
            }

            if (inAll) res.add(x);
        }

        return res;
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