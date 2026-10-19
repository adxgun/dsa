class MovingAverage {

    private List<Integer> values = new ArrayList<>();
    private int size = 0;
    private int total = 0;

    public MovingAverage(int size) {
        this.size = size;
    }
    
    public double next(int val) {
        int curSize = values.size();
        if (curSize >= size) {
            int win = curSize - size;
            total -= values.get(win);
            values.removeFirst();
        }

        values.add(val);
        total += val;
        return (double) total / values.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */