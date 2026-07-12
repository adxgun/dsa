class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long total = 0;
        for (int c : chalk) total += c;

        long remaining = k % total;
        for (int i = 0; i < chalk.length; i++) {
            if (remaining < chalk[i]) return i;
            remaining -= chalk[i];
        }

        return 0;
    }
}