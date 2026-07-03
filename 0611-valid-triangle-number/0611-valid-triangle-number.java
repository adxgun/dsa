class Solution {
    public int triangleNumberA(int[] nums) {
        Arrays.sort(nums);
        int count = 0, i = 0, j = nums.length;
        while(i < j) {
            int sum = nums[i] + nums[j - 1];
            int side3 = nums[j - 1];
            if (sum > side3) {
                count += j - i;
                j--;
            } else i++;
        }
        return count;
    }

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;

        // Fix the largest side k, then use two pointers for i and j
        for (int k = nums.length - 1; k >= 2; k--) {
            int i = 0, j = k - 1;
            while (i < j) {
                if (nums[i] + nums[j] > nums[k]) {
                    // all pairs from i to j-1 with j are valid
                    count += j - i;
                    j--;
                } else {
                    i++;
                }
            }
        }

        return count;
    }
}