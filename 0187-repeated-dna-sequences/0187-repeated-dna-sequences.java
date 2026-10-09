class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seqs = new HashSet<>();
        Set<String> output = new HashSet<>();
        int K = 10, n = s.length();
        for (int right = 0; right < n - K + 1; right++) {
            String sub = s.substring(right, right + K);
            if (seqs.contains(sub)) output.add(sub);
            seqs.add(sub);
        }

        return new ArrayList<>(output);
    }
}