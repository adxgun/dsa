class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return result;
        }

        
        result[0] = searchRange(nums, target, true);
        result[1] = searchRange(nums, target, false);
        return result;
    }

    private int searchRange(int[] nums, int target, boolean first) {
        int left = 0, right = nums.length - 1;
        int idx = -1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                idx = mid;
                if (first) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return idx;
    }
}