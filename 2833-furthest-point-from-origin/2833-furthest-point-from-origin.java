class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int n = 0, l = 0, r = 0;
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'L') l++;
            if (moves.charAt(i) == 'R') r++;
        }

        for (char c : moves.toCharArray()) {
            if (c == '_' && l >= r) n--;
            else if (c == '_' && r >= l) n++;
            else if (c == 'R') n++;
            else if (c == 'L') n--;
        }

        return Math.abs(n);
    }
}