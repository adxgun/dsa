class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i == 0) l1.add(nums[i]);
            else if (i == 1) l2.add(nums[i]);
            else {
                if (l1.getLast() > l2.getLast()) l1.add(nums[i]);
                else l2.add(nums[i]);
            }
        }

        for (int i = 0; i < l1.size(); i++) res[i] = l1.get(i);
        for (int i = 0; i < l2.size(); i++) res[i + l1.size()] = l2.get(i);
        return res;
    }
}