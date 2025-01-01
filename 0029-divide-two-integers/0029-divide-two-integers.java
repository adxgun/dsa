class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // ^ is XOR
        // (-2 xor 1) = true
        // (-2 xor -2) = false
        // (2 xor 2) = false
        boolean isNegative = (dividend < 0) ^ (divisor < 0);
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        int quotent = 0;

        while(absDividend >= absDivisor) {
            long tmpDivisor = absDivisor;
            int multiple = 1;

            while(absDividend >= (tmpDivisor << 1)) {
                tmpDivisor <<= 1;
                multiple <<= 1;
            }

            absDividend -= tmpDivisor;
            quotent += multiple;
        }
        return isNegative ? -quotent : quotent;
    }
}