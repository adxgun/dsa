class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int[] answer = new int[k];
        int[][] strength = new int[m][2];
        
        for (int i = 0; i < mat.length; i++) {
            strength[i][0] = lowerBound(mat[i], 1); // number of 1s(soldiers)
            strength[i][1] = i; // original index;
        }

        Arrays.sort(strength, (a, b) -> 
            a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        
        for (int i = 0; i < k; i++) {
            answer[i] = strength[i][1];    
        }

        return answer;
    }

    private int lowerBound(int[] nums, int t) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == t) lo = mid + 1;
            else hi = mid - 1;
        }
        return lo;
    }
}