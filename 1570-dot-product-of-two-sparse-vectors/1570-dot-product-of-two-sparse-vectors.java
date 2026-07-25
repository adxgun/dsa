class SparseVector {
    
    private int[] nums;
    SparseVector(int[] nums) {
        this.nums = nums;
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int sum = 0;
        int[] left = vec.getNums();
        for (int i = 0; i < nums.length; i++) {
            sum += left[i] * nums[i];
        }
        return sum;
    }

    public int[] getNums() {
        return this.nums;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);