class Solution {
    public int smallestNumber(int n, int t) {
        while (n > 0) {
            if (productOf(n) % t == 0) return n;
            n++;
        }
        return -1;
    }

    private int productOf(int n) {
        int product = 1;
        while (n > 0) {
            product *= n % 10;
            n /= 10;
        }
        return product;
    }
}