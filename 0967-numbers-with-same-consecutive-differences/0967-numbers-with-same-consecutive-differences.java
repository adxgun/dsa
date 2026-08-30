class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= 9; i++) {
            queue.offer(i);
        }

        for (int len = 1; len < n; len++) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int num = queue.poll();
                int lastDigit = num % 10;

                for (int next : new int[]{lastDigit - k, lastDigit + k}) {
                    if (next >= 0 && next <= 9) {
                        queue.offer(num * 10 + next);
                    }

                    if (k == 0) break;
                }
            }
        }

        int[] res = new int[queue.size()];
        int i = 0;
        while (!queue.isEmpty()) res[i++] = queue.poll();
        return res;
    }
}