class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;

        int reversed = reverse(x);
        return x == reversed;
    }

    int reverse(int x) {
        int reversed = 0;
        while(x != 0) {
            int digit = x % 10;
            x /= 10;

            reversed = 10 * reversed + digit; 
        }
        return reversed;
    }
}