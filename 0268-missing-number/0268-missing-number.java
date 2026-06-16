class Solution {
    public int missingNumberA(int[] nums) {
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) map.put(nums[i], i + 1);

        for (int j = 0; j < nums.length; j++) {
            if (map.get(j + 1) == null) return j + 1;
        }

        return 0;
    }

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int lo = 0, hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == mid) lo = mid + 1;
            else hi = mid - 1;
        }
        return lo;
    }
}