class Solution {
    public int compress(char[] chars) {
        int n = chars.length, read = 0, write = 0;
        String result = "";
        while(read < n) {
            char current = chars[read];
            int count = 0;
            while(read < n && current == chars[read]) {
                read++;
                count++;
            }

            chars[write] = current;
            write++;
            if (count > 1) {
                char[] values = String.valueOf(count).toCharArray();
                for (char c : values) {
                    chars[write] = c;
                    write++;
                }
            }
            
        }
        return write;
    }   
}