class Solution {
    public int[][] highFive(int[][] items) {
        Arrays.sort(items, (a, b) -> b[1] - a[1]);
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> count = new HashMap<>();
        
        for (int[] item : items) {
            if (count.merge(item[0], 1, Integer::sum) <= 5) {
                map.merge(item[0], item[1], Integer::sum);
            }
        }

        int k = 0;
        int[][] result = new int[map.size()][2];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result[k++] = new int[]{
                entry.getKey(),
                entry.getValue() / 5,
            };
        }
        return result;
    }
}