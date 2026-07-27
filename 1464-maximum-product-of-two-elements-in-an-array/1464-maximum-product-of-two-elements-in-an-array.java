class Solution {
    public int maxProductA(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int i = nums[n - 1];
        int j = nums[n - 2];
        return (i - 1) * (j - 1);
    }

    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        for (int x : nums) {
            maxHeap.offer(x);
            if (maxHeap.size() > 2) maxHeap.poll();
        }

        return (maxHeap.poll() - 1) * (maxHeap.poll() - 1);
    }
}