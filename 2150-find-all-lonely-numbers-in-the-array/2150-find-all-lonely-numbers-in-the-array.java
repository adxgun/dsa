class Solution {
    public List<Integer> findLonely(int[] nums) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int x : nums) seen.merge(x, 1, Integer::sum);

        List<Integer> res = new ArrayList<>();
        for (int x : nums) {
            int l = x + 1, r = x - 1;
            if (seen.get(x) == 1 && !seen.containsKey(l) && !seen.containsKey(r)) {
                res.add(x);
            }
        }

        return res;
    }
}