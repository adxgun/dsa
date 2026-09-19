class Solution {
    public int magicalString(int n) {
        if (n == 1 || n == 2) return 1;

        int count = 1, startIndex = 2;
        StringBuilder sb = new StringBuilder("122");
        char toappend = '1'; // 3rd char is 2 so we append two occurence of '1'

        for (int i = 0; i < n; i++) {
            char nextChar = sb.charAt(startIndex);
            int nextCount = nextChar - '0';
            for (int j = 0; j < nextCount; j++) {
                if (n == sb.length()) break;
                sb.append(toappend);

                if (toappend == '1') count += 1;
            }

            if (n == sb.length()) break;
            toappend = (toappend == '2') ? '1' : '2';
            startIndex += 1;
        }
        
        return count;
    }
}