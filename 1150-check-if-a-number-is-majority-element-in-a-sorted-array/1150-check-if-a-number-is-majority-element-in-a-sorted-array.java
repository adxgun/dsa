class Solution {
    public boolean isMajorityElementA(int[] nums, int target) {
        Map<Integer, Integer> freq = new HashMap<>();
        int n = nums.length;
        for (int x : nums) {
            if (freq.merge(x, 1, Integer::sum) > n / 2) return true;
        }
        return false;
    }

    public boolean isMajorityElement(int[] nums, int target) {
        int count = 0;
        for (int x : nums) {
            count = x == target ? count + 1 : count;
        }

        return count > nums.length / 2;
    }

    public boolean isMajorityElementB(int[] nums, int target) {
        int n = nums.length;
        int upper = upperBound(nums, target);
        int lower = lowerBound(nums, target);
        return (upper - lower > n / 2);
    }

    private int lowerBound(int[] nums, int t) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] <= t) hi = mid - 1;
            else lo = mid + 1;
        }
        return lo;
    }

    private int upperBound(int[] nums, int t) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] <= t) lo = mid + 1;
            else hi = mid - 1;
        }
        return lo;
    }
}