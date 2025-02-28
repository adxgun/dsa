class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        if (candies == null || candies.length <= 0) {
            return List.of();
        }

        int n = candies.length;
        List<Boolean> result = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (candies[i] > max) {
                max = candies[i];
            }
        }

        for (int i = 0; i < n; i++) {
            int next = candies[i] + extraCandies;
            if (next >= max) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }
}