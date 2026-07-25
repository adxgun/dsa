class SparseVector {
    
    public Map<Integer, Integer> nonZeros;
    SparseVector(int[] arr) {
        this.nonZeros = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) nonZeros.put(i, arr[i]);
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int sum = 0;

        Map<Integer, Integer> smaller = this.nonZeros.size() <= vec.nonZeros.size() ? this.nonZeros : vec.nonZeros;

        Map<Integer, Integer> other = this.nonZeros == smaller ? vec.nonZeros : this.nonZeros;
        for (Map.Entry<Integer, Integer> entry : smaller.entrySet()) {
            Integer otherValue = other.get(entry.getKey());
            if (otherValue != null) sum += otherValue * entry.getValue();
        }
        return sum;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);