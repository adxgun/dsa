class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        for (int x : arr1) {
            boolean all = true;
            for (int y : arr2) {
                if (Math.abs(y - x) <= d) {
                    all = false;
                    break;
                }
            }

            if (all) count += 1;
        }
        return count;
    }
}