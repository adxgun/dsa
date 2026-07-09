class Solution {
    public int countElements(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int x : arr) set.add(x);
        
        int C = 0;
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i] + 1)) C++;
        }
        return C;
    }
}