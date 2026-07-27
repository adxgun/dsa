class Solution {
    public int maxProductA(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int i = nums[n - 1];
        int j = nums[n - 2];
        return (i - 1) * (j - 1);
    }

    public int maxProductB(int[] nums) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        for (int x : nums) {
            maxHeap.offer(x);
            if (maxHeap.size() > 2) maxHeap.poll();
        }

        return (maxHeap.poll() - 1) * (maxHeap.poll() - 1);
    }

    public int maxProduct(int[] nums) {
        int max = 0, maxTwo = 0;
        for (int x : nums) {
            if (x > max) {
                maxTwo = max;
                max = x;
            } else {
                maxTwo = Math.max(x, maxTwo);
            }
        }

        return (max - 1) * (maxTwo - 1);
    }
}