class Solution {
    public String oddString(String[] words) {
        int[] d0 = difference(words[0]);
        int[] d1 = difference(words[1]);
        int[] d2 = difference(words[2]);

        int[] normal = Arrays.equals(d0, d1) || Arrays.equals(d0, d2) ? d0 : d1;
        for (int i = 0; i < words.length; i++) {
            int[] diff = difference(words[i]);
            if (!Arrays.equals(normal, diff)) return words[i];
        }
        return "";
    }

    private int[] difference(String s) {
        int n = s.length();
        int[] res = new int[n - 1];
        for (int i = 1; i < n; i++) {
            res[i - 1] = s.charAt(i) - s.charAt(i - 1);
        }
        return res;
    }
}