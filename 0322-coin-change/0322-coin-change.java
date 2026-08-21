class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        
        boolean[] visited = new boolean[amount + 1];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        visited[0] = true;

        int coinsUsed = 0;
        while (!queue.isEmpty()) {
            coinsUsed++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int coin : coins) {
                    int next = cur + coin;
                    if (next == amount) return coinsUsed;

                    if (next < amount && !visited[next]) {
                        queue.offer(next);
                        visited[next] = true;
                    }
                }
            }
        }
        return -1;
    }
}