class Solution {

    private List<List<Integer>> result = new ArrayList<>();
    private boolean[] used;
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> track = new ArrayList<>();
        used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, track);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> track) {
        if (nums.length == track.size()) {
            result.add(new ArrayList<>(track));
            return;
        }

        int prevNum = -666;
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (prevNum == nums[i]) continue;

            track.addLast(nums[i]);
            used[i] = true;
            prevNum = nums[i];
            backtrack(nums, track);

            used[i] = false;
            track.removeLast();
        }
    }
}