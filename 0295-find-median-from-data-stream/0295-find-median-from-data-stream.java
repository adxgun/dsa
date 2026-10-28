class MedianFinder {

    // 1 5 3 4 9 7 2 6 8
    private List<Integer> ls;
    private int size;

    private PriorityQueue<Integer> lo = new PriorityQueue<>((a, b) -> Integer.compare(b, a)); // max heap
    private PriorityQueue<Integer> hi = new PriorityQueue<>(); // min heap

    public MedianFinder() {
        ls = new ArrayList<>();
        this.size = 0;
    }
    
    public void addNum1(int num) {
        int lo = 0, hi = ls.size();
        while(lo < hi) {
            int mid = (lo + hi) / 2;
            if (ls.get(mid) < num) lo = mid + 1;
            else hi = mid;
        }

        ls.add(lo, num);
        size += 1;
    }

    public void addNum(int num) {
        lo.offer(num);
        hi.offer(lo.poll());
        
        if (hi.size() > lo.size()) lo.offer(hi.poll());
    }

    public double findMedian() {
        if (lo.size() > hi.size()) return (double) lo.peek();
        else return ((double) (hi.peek() + lo.peek()) / 2);
    }
    
    public double findMedian1() {
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