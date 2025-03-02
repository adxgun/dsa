class Solution {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }

        int n = chars.length;
        int i = 0;
        int writePos = 0;

        while(i < n) {
            char current = chars[i];
            int count = 0;

            while(i < n && chars[i] == current) {
                i++;
                count++;
            }

            chars[writePos] = current;
            writePos++;

            if (count > 1) {
                String value = String.valueOf(count);
                for (char c : value.toCharArray()) {
                    chars[writePos] = c;
                    writePos++;
                }
            }
        }    
        return writePos;
    }
}