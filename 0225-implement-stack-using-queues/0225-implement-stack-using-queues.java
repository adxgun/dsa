class MyStack {

    private final Deque<Integer> queue;
    public MyStack() {
        queue = new ArrayDeque<>();
    }
    
    public void push(int x) {
        int n = queue.size();
        queue.offer(x);
        while (n-- > 0) queue.offer(queue.poll());
    }
    
    public int pop() {
        return queue.poll();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */