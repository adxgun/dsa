class Solution {
    public int reverse(int x) {
        int reversed = 0;

        while(x != 0) {
            int digit = x % 10; // 3 => 2 => 2/10 -> 2
            x /= 10; // x = 123/10 => 12 => 12/10 => 1 -> 1/10 -> 1

            if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }

            if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }

            reversed = reversed * 10 + digit; // 0 * 10 + 3 => 3; 3 * 10 + 2 => 32; 32 * 10 + 1 -> 32 * 10 + 1
        }
        return reversed;
    }
}