class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        if (candies == null || candies.length == 0) {
            return List.of();
        }

        int highest = 0;
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] > highest) {
                highest = candies[i];
            }
        }

        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= highest) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }
}