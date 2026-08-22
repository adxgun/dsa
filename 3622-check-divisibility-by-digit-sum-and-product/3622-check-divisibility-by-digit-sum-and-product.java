class Solution {
    public boolean checkDivisibility(int n) {
        int[] values = sumAndProduct(n);
        return (n % (values[0] + values[1])) == 0;
    }

    private int[] sumAndProduct(int n) {
        int sum = 0, product = 1;
        while (n > 0) {
            int rem = n % 10;
            sum += rem;
            product *= rem;
            n /= 10;
        }

        return new int[]{sum, product};
    }
}