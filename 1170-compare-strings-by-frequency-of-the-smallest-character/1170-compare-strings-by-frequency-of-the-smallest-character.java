class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] wordfs = new int[words.length];
        for (int i = 0; i < words.length; i++) wordfs[i] = f(words[i]);

        Arrays.sort(wordfs);
        int m = words.length;
        int[] answer = new int[queries.length];

        for (int x = 0; x < queries.length; x++) {
            int lo = 0, hi = m - 1;
            int fq = f(queries[x]);
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (wordfs[mid] <= fq) lo = mid + 1;
                else hi = mid - 1;
            }

            answer[x] = m - lo;
        }

        return answer;
    }

    private int f(String s) {
        int count = 0, min = 'z' + 1;
        for (char x : s.toCharArray()) {
            if (x < min) {
                min = x;
                count = 1;
            } else if (x == min) {
                count++;
            }
        }
        return count;
    }
}