class FirstUnique {

    private final Map<Integer, Integer> count;
    private final Queue<Integer> queue;
    
    public FirstUnique(int[] nums) {
        count = new HashMap<>();
        queue = new ArrayDeque<>();

        for (int x : nums) add(x);
    }
    // 2:1, 3:1, 5:1
    public int showFirstUnique() {        
        while (!queue.isEmpty() && count.get(queue.peek()) > 1) {
            queue.poll();
        }

        return queue.isEmpty() ? -1 : queue.peek();
    }
    
    public void add(int value) {
        if (count.merge(value, 1, Integer::sum) == 1) {
            queue.offer(value);
        }
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */