class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length, left = 0;

        // longest non-decreasing prefix
        while (left + 1 < n && arr[left] <= arr[left + 1]) left++;
        if (left == n - 1) return 0; // already sorted

        int right = n - 1;
        while (right > 0 && arr[right - 1] <= arr[right]) right--;
        
        int result = Math.min(n - 1 - left, right);
        int i = 0, j = right;
        while (i <= left && j < n) {
            if (arr[i] <= arr[j]) {
                result = Math.min(result, j - i - 1);
                i++;
            } else j++;
        }
        return result;
    }
}