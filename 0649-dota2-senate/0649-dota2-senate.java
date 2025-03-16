class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Deque<Integer> radiantQueue = new ArrayDeque<>();
        Deque<Integer> direQueue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                radiantQueue.offer(i);
            } else {
                direQueue.offer(i);
            }
        }

        while(!radiantQueue.isEmpty() && !direQueue.isEmpty()) {
            int rIdx = radiantQueue.poll();
            int dIdx = direQueue.poll();

            if (rIdx < dIdx) {
                radiantQueue.offer(rIdx + n);
            } else {
                direQueue.offer(dIdx + n);
            }
        }

        return direQueue.isEmpty() ? "Radiant" : "Dire";
    }
}