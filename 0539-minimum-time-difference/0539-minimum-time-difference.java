class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> minutes = new ArrayList<>();
        for (String tp : timePoints) {
            int hr = Integer.parseInt(tp.substring(0, 2));
            int min = Integer.parseInt(tp.substring(3));
            minutes.add(hr * 60 + min);
        }

        Collections.sort(minutes);
        int best = Integer.MAX_VALUE;
        for (int i = 1; i < minutes.size(); i++) {
            best = Math.min(best, minutes.get(i) - minutes.get(i - 1));
        }
        // wrap-around gap: last time → midnight → first time
        best = Math.min(best, minutes.get(0) + 1440 - minutes.get(minutes.size() - 1));
        return best;
    }
}