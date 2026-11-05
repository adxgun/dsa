class Solution {
    // value - 25 = reversed
    public String mapWordWeights(String[] words, int[] weights) {
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            int sum = 0;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (i < weights.length) sum += weights[i];
            }
            // sb.append(alphabets.charAt(25 - (sum % 26)));
            int rem = sum % 26;
            sb.append((char)('z' - rem));
        }

        return sb.toString();
    }
}