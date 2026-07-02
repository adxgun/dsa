class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        java.util.Arrays.sort(heaters);
        int radius = 0;
        for (int house : houses) {
            radius = Math.max(radius, nearestDistance(heaters, house));
        }
        return radius;
    }

    // Distance from `house` to the closest heater in the sorted array.
    private int nearestDistance(int[] heaters, int house) {
        int lo = 0, hi = heaters.length - 1;

        // Binary search for the insertion point: after the loop,
        // `lo` is the index of the first heater >= house.
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (heaters[mid] == house) {
                return 0;                 // heater sits exactly on the house
            } else if (heaters[mid] < house) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        // Now `lo` = insertion point, `hi` = lo - 1.
        // Nearest heater is heaters[hi] (just left) or heaters[lo] (just right).
        int best = Integer.MAX_VALUE;
        if (hi >= 0) {                                  // a heater to the left exists
            best = Math.min(best, house - heaters[hi]);
        }
        if (lo < heaters.length) {                      // a heater to the right exists
            best = Math.min(best, heaters[lo] - house);
        }
        return best;
    }
}