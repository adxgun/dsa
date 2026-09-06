class Solution {
    private List<String> result = new ArrayList<>();
    private List<String> path = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        backtrack(s, 0, 0);
        return result;
    }

    private void backtrack(String s, int start, int segments) {
        if (segments == 4) {
            if (s.length() == start) {
                result.add(String.join(".", path));
            }
            return;
        }

        for (int len = 1; len <= 3; len++) {
            if (start + len > s.length()) continue;

            String seg = s.substring(start, start + len);
            if (!isValid(seg)) continue;

            path.add(seg);
            backtrack(s, start + len, segments + 1);
            path.remove(path.size() - 1);
        }
    }

    private boolean isValid(String seg) {
        if (seg.length() > 1 && seg.charAt(0) == '0') return false;
        return Integer.parseInt(seg) <= 255;
    }
}