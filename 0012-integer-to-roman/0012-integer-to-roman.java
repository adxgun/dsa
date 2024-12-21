class Solution {
    public String intToRoman(int num) {
        final int[] VALUES = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        final String[] SYMBOLS = 
            new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < VALUES.length; i++) {
            while(num >= VALUES[i]) {
                num = num - VALUES[i];
                sb.append(SYMBOLS[i]);
            }

            if (num == 0) {
                break;
            }
        }
        return sb.toString();
    }
}