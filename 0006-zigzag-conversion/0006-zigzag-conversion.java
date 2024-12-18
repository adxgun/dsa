class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int cur = 0;
        int cursor = 1;
        for (char c: s.toCharArray()) {
            rows[cur].append(c);
            if (cur == 0) {
                cursor = 1;
            } else if (cur == numRows - 1) {
                cursor = -1;
            }
            cur += cursor;
        }

        String result = "";
        for (StringBuilder sb: rows) {
            result += sb.toString();
        }

        return result;
    }
}