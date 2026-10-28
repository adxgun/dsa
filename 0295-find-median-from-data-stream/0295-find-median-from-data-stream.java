class MedianFinder {

    // 1 5 3 4 9 7 2 6 8
    private List<Integer> ls;
    private int size;

    private PriorityQueue<Integer> lo = new PriorityQueue<>((a, b) -> Integer.compare(b, a)); // max heap
    private PriorityQueue<Integer> hi = new PriorityQueue<>(); // min heap

    public MedianFinder() {}

    public void addNum(int num) {
        lo.offer(num);
        hi.offer(lo.poll());
        
        if (hi.size() > lo.size()) lo.offer(hi.poll());
    }

    public double findMedian() {
        if (lo.size() > hi.size()) return (double) lo.peek();
        else return ((double) (hi.peek() + lo.peek()) / 2);
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */