class TaskManager {

    private final Map<Integer, Integer> owner; // taskId -> userId
    private final Queue<int[]> heap;
    private final Map<Integer, Integer> priority; // taskId -> priority
    
    public TaskManager(List<List<Integer>> tasks) {
        owner = new HashMap<>();
        priority = new HashMap<>();
        heap = new PriorityQueue<>((a, b) -> {
            return a[0] == b[0] ? Integer.compare(b[1], a[1]) : Integer.compare(b[0], a[0]);
        });

        for (List<Integer> task : tasks) {
            int uid = task.get(0), taskId = task.get(1), p = task.get(2);
            add(uid, taskId, p);
        }
    }
    
    public void add(int userId, int taskId, int p) {
        owner.put(taskId, userId);
        priority.put(taskId, p);
        heap.offer(new int[]{p, taskId});
    }
    
    public void edit(int taskId, int newPriority) {
        priority.put(taskId, newPriority);
        heap.offer(new int[]{newPriority, taskId});
    }
    
    public void rmv(int taskId) {
        owner.remove(Integer.valueOf(taskId));
        priority.remove(Integer.valueOf(taskId));
    }
    
    public int execTop() {
        if (heap.isEmpty()) return -1;
        while (!heap.isEmpty()) {
            int[] top = heap.poll();
            int prio = top[0], taskId = top[1];
            Integer cur = priority.get(taskId);
            if (cur == null || cur != prio) continue;
            priority.remove(Integer.valueOf(taskId));
            return owner.remove(Integer.valueOf(taskId));
        }
        return -1;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */