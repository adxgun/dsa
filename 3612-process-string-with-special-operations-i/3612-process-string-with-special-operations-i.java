class Solution {
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                if (sb.length() >= 1) sb.deleteCharAt(sb.length() - 1);
            } else if (s.charAt(i) == '#') {
                String cur = sb.toString();
                sb.append(cur);
            } else if (s.charAt(i) == '%') {
                sb.reverse();
            } else sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}