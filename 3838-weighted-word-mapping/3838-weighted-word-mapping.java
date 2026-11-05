class Solution {
    // value - 25 = reversed
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            int sum = 0;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (i < weights.length) sum += weights[i];
            }
            int rem = sum % 26;
            sb.append((char)('z' - rem));
        }

        return sb.toString();
    }
}