class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Set<Integer> res = new HashSet<>();
        int target = nums.length / 3;

        for (int x : nums) {
            if (count.merge(x, 1, Integer::sum) > target && !res.contains(x)) {
                res.add(x);
            }
        }

        return new ArrayList<>(res);
    }
}