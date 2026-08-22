class Solution {
    public boolean checkDivisibility(int n) {
        int[] values = sumAndProduct(n);
        return (n % (values[0] + values[1])) == 0;
    }

    private int[] sumAndProduct(int n) {
        int sum = 0, product = 1;
        while (n > 0) {
            sum += (n % 10);
            product *= (n % 10);
            n /= 10;
        }

        return new int[]{sum, product};
    }
}