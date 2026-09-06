class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> track = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return result;    
    }

    private void backtrack(int[] nums, int start) {
        result.add(new ArrayList<>(track));

        for (int i = start; i < nums.length; i++) {
            track.addLast(nums[i]);
            backtrack(nums, i + 1);
            track.removeLast();
        }
    }
}