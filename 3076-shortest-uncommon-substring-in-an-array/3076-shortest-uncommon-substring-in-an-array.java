class Solution {
    public String[] shortestSubstrings(String[] arr) {
        int n = arr.length;
        String[] answer = new String[n];
        Map<String, Integer> count = new HashMap<>();

        for (String s : arr) {
            Set<String> subs = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                for (int j = i + 1; j <= s.length(); j++) {
                    subs.add(s.substring(i, j));
                }
            }

            for (String sub : subs) count.merge(sub, 1, Integer::sum);
        }

        for (int k = 0; k < n; k++) {
            String s = arr[k];
            String best = "";
            for (int len = 1; len <= s.length() && best.isEmpty(); len++) {
                for (int i = 0; i + len <= s.length(); i++) {
                    String sub = s.substring(i, i + len);
                    if (count.get(sub) == 1 && (best.isEmpty() || sub.compareTo(best) < 0)) {
                        best = sub;
                    }
                }
            }
            answer[k] = best;
        }

        return answer;
    }
}