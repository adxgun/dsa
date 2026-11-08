class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Deque<Integer> waiting = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!waiting.isEmpty() && temperatures[i] > temperatures[waiting.peek()]) {
                int day = waiting.pop();
                answer[day] = i - day;
            }

            waiting.push(i);
        }

        return answer;
    }
}