class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> index = new HashMap<>();
        for (List<String> next : knowledge) {
            index.put(next.get(0), next.get(1));
        }

        int n = s.length(), i = 0;
        StringBuilder result = new StringBuilder();
        while (i < n) {
            if (s.charAt(i) == '(') {
                StringBuilder key = new StringBuilder();
                int start = i + 1;
                while (start < n && Character.isAlphabetic(s.charAt(start))) {
                    key.append(s.charAt(start));
                    start++;
                }
                i = start;
                result.append(index.getOrDefault(key.toString(), "?"));
            } else if (Character.isAlphabetic(s.charAt(i))) {
                while (i < n && Character.isAlphabetic(s.charAt(i))) {
                    result.append(s.charAt(i));
                    i++;
                }
            } else {
                i++;
            }
        }

        return result.toString();
    }
}