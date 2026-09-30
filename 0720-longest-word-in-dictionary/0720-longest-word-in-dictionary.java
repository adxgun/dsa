class Solution {
    public String longestWord(String[] w) {
        Arrays.sort(w);

        Set<String> buildable = new HashSet<>();
        buildable.add(""); // lets single letter count as buildable.
        String best = "";

        for (String s : w) {
            String prev = s.substring(0, s.length() - 1);
            if (buildable.contains(prev)) {
                buildable.add(s);

                if (s.length() > best.length()) best = s;
            }
        }

        return best;
    }
}