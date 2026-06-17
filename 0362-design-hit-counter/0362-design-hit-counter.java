class HitCounter {
    private int[] times;
    private int[] counts;

    public HitCounter() {
        times = new int[300];
        counts = new int[300];
    }

    public void hit(int timestamp) {
        int idx = timestamp % 300;
        if (times[idx] != timestamp) {
            times[idx] = timestamp;
            counts[idx] = 1;
        } else {
            counts[idx]++;
        }
    }

    public int getHits(int timestamp) {
        int total = 0;
        for (int i = 0; i < 300; i++) {
            if (timestamp - times[i] < 300) {
                total += counts[i];
            }
        }
        return total;
    }
}