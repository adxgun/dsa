class MedianFinder {

    private List<Integer> ls;
    private int size;

    public MedianFinder() {
        ls = new ArrayList<>();
        this.size = 0;
    }
    
    public void addNum(int num) {
        int lo = 0, hi = ls.size();
        while(lo < hi) {
            int mid = (lo + hi) / 2;
            if (ls.get(mid) < num) lo = mid + 1;
            else hi = mid;
        }

        ls.add(lo, num);
        size += 1;
    }
    
    public double findMedian() {
        boolean isEven = size % 2 == 0;
        int mid = size / 2;
        if (!isEven) return ls.get(mid);
        int left = ls.get(mid - 1), right = ls.get(mid);
        return (double) (left + right) / 2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */