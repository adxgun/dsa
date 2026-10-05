class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        final String digits = "123456789";
        List<Integer> result = new ArrayList<>();
        for (int len = 2; len <= 9; len++) {
            for (int start = 0; start + len <= 9; start++) {
                int num = Integer.parseInt(digits.substring(start, len + start));
                if (num > high) return result;
                if (num >= low) result.add(num);
            }
        }

        return result;
    }

    private boolean isSeq(int num) {
        int prev = -1;
        while (num > 0) {
            int x = num % 10;
            if (prev != -1 && (prev - x) != 1) return false;

            prev = x;
            num /= 10;
        }
        return true;
    }
}