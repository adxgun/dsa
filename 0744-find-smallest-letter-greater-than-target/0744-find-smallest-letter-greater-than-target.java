class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int lo = 0, hi = letters.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            System.out.println(letters[mid] > target);
            System.out.println(letters[mid] + " > " + target);
            if (letters[mid] > target) hi = mid - 1;
            else lo = mid + 1;
        }
        return lo >= letters.length ? letters[0] : letters[lo];
    }
}