class Solution {
    public int findTheWinner(int n, int k) {
        Deque<Integer> circle = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) circle.offer(i);

        while (circle.size() > 1) {
            for (int steps = 1; steps < k; steps++) {
                circle.offer(circle.poll());
            }

            circle.poll();
        }

        return circle.peek();
    }
}