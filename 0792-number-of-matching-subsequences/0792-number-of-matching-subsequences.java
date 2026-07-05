class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        // positions[c] = sorted list of indices where character c appears in s
        List<Integer>[] positions = new List[26];
        for (int c = 0; c < 26; c++) positions[c] = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            positions[s.charAt(i) - 'a'].add(i);
        }

        int count = 0;
        for (String word : words) {
            if (isSubsequence(word, positions)) count++;
        }
        return count;
    }

    private boolean isSubsequence(String word, List<Integer>[] positions) {
        int prev = -1;   // index in s of the last matched character
        for (char ch : word.toCharArray()) {
            List<Integer> idx = positions[ch - 'a'];
            if (idx.isEmpty()) return false;              // char not in s at all

            // binary search: first position strictly greater than prev
            int pos = upperBound(idx, prev);
            if (pos == idx.size()) return false;          // no occurrence after prev
            prev = idx.get(pos);                           // advance to it
        }
        return true;
    }

    // first index in list whose value is strictly greater than target
    private int upperBound(List<Integer> list, int target) {
        int lo = 0, hi = list.size();
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (list.get(mid) <= target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}