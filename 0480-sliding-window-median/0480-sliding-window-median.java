class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        Comparator<Integer> cmp = (a, b) -> nums[a] != nums[b] ? 
            Integer.compare(nums[a], nums[b]) : Integer.compare(a, b);

        TreeSet<Integer> lo = new TreeSet<>(cmp);
        TreeSet<Integer> hi = new TreeSet<>(cmp);
        
        double[] answer = new double[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {

            if (lo.isEmpty() || nums[i] <= nums[lo.last()]) lo.add(i);
            else hi.add(i);

            if (i >= k && !lo.remove(i - k)) hi.remove(i - k);

            while (lo.size() > hi.size() + 1) hi.add(lo.pollLast());
            while (hi.size() > lo.size()) lo.add(hi.pollFirst());

            if (i >= k - 1) {
                answer[i - k + 1] = (k % 2 == 1) ? 
                nums[lo.last()] : 
                ((double) nums[lo.last()] + nums[hi.first()]) / 2.0;
            }
        }

        return answer;
    }
}