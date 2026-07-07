class SnapshotArray {

    private List<int[]>[] history;
    private int snapId = 0;

    public SnapshotArray(int length) {
        history = new List[length];
        for (int i = 0; i < length; i++) {
            history[i] = new ArrayList<>();
            history[i].add(new int[]{0, 0});
        }
    }
    
    public void set(int index, int val) {
        List<int[]> h = history[index];
        int[] last = h.get(h.size() - 1);
        if (last[0] == snapId) {
            last[1] = val;
        } else {
            h.add(new int[]{snapId, val});
        }
    }
    
    public int snap() {
        return snapId++;
    }
    
    public int get(int index, int snap_id) {
        List<int[]> h = history[index];
        int lo = 0, hi = h.size() - 1, ans = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (h.get(mid)[0] <= snap_id) {
                ans = h.get(mid)[1];
                lo = mid + 1;
            } else hi = mid - 1;
        }
        return ans;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */