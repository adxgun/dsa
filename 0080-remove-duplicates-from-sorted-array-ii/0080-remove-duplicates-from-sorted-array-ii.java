class Solution {
    public int removeDuplicates1(int[] nums) {
        int i = 0, n = nums.length, total = 0, cur = 0;

        while(i < n) {
            int current = nums[i];
            int count = 0;
            while(i < n && current == nums[i]) {
                i++;
                count++;
            }

            int write = Math.min(count, 2);
            total += write;
            for (int j = cur; j < cur + write; j++) {
                nums[j] = current;
            }

            cur += write;
        }
        return total;
    }

    public int removeDuplicates(int[] nums) {
        int cur = 0, n = nums.length, i = 0, total = 0;
        while (i < n) {
            int current = nums[i];
            int count = 0;
            while (i < n && current == nums[i]) {
                count++;
                i++;
            }

            int write = Math.min(count, 2);
            total += write;
            for (int j = cur; j < cur + write; j++) {
                nums[j] = current;
            }

            cur += write;
        }
        return total;
    }
}