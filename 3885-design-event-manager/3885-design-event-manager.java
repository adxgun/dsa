class EventManager {
    private PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
        if (a[1] == b[1]) return a[0] - b[0];
        else return b[1] - a[1];
    });
    private Map<Integer, Integer> current = new HashMap<>();

    public EventManager(int[][] events) {
       for (int[] ev : events) {
            heap.offer(ev);
            current.put(ev[0], ev[1]);
       }
    }
    
    public void updatePriority(int eventId, int newPriority) {
        current.put(eventId, newPriority);
        heap.offer(new int[]{eventId, newPriority}); 
    }
    
    public int pollHighest() {
        while (!heap.isEmpty()) {
            int[] top = heap.poll();
            int id = top[0], prio = top[1];
            
            if (current.containsKey(id) && current.get(id) == prio) {
                current.remove(id);
                return id;
            }
        }
        return -1;
    }
}

/**
 * Your EventManager object will be instantiated and called as such:
 * EventManager obj = new EventManager(events);
 * obj.updatePriority(eventId,newPriority);
 * int param_2 = obj.pollHighest();
 */