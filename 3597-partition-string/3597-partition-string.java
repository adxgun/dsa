class Solution {
    public List<String> partitionString(String s) {
        Set<String> seen = new HashSet<>();
        List<String> segments = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c);
            String val = sb.toString();
            if (seen.add(val)) {
                segments.add(val);
                sb.setLength(0);
            }
        }

        return segments;
        // result.sort((a, b) -> a.compareTo(b));
        // return result;
    }
}