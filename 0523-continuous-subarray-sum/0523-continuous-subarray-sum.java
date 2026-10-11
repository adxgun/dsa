class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        Map<Integer, Integer> seen = new HashMap<>();
        seen.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = sum % k;
            
            if (seen.containsKey(rem)) {
                if ((i - seen.get(rem)) >= 2) return true;
            } else {
                seen.put(rem, i);
            }
        }

        return false;
    }
}