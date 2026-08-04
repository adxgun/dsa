class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();
        
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        Set<Integer> values = new HashSet<>();
        for (int x : nums) {
            values.add(x);
            min = Math.min(x, min);
            max = Math.max(x, max);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            if (!values.contains(i)) res.add(i);
        }

        return res;
    }
}