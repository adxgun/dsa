class Solution {
    public String evaluate1(String s, List<List<String>> knowledge) {
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

    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> index = new HashMap<>();
        for (List<String> k : knowledge) index.put(k.get(0), k.get(1));

        StringBuilder result = new StringBuilder();
        int i = 0, n = s.length();
        while (i < n) {
            char c = s.charAt(i);
            if (c == '(') {
                int close = s.indexOf(')', i);
                result.append(index.getOrDefault(s.substring(i + 1, close), "?"));
                i = close + 1; // skip past ')'
            } else {
                result.append(c);
                i++;
            }
        }
        return result.toString();
    }
}