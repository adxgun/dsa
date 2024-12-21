class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, maxArea = 0;

        while(left < right) {
            int curHeight = Math.min(height[right], height[left]);
            int width = right - left;
            int area = curHeight * width;
            if (area > maxArea) {
                maxArea = area;
            }

            if (height[right] < height[left]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }
}