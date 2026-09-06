class Solution {

    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> track = new ArrayList<>();
    private boolean[] used;
    
    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        backtrack(nums);
        return result;
    }

    private void backtrack(int[] nums) {
        if (nums.length == track.size()) {
            result.add(new ArrayList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            used[i] = true;
            track.addLast(nums[i]);
            backtrack(nums);

            track.removeLast();
            used[i] = false;
        }
    }
}